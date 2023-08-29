<template>
  <v-container>
    <v-card class="mx-auto" width="800">
      <router-link :to="{ name: 'articleList' }" style="text-decoration: none"
        >《《 이전</router-link
      >
      <v-card-text>
        <div>{{ article.articleBoardType }}</div>
        <p class="text-h4 text--primary">
          {{ article.articleTitle }}
        </p>
        <p>{{ article.articleWriter }}</p>
        <div class="text--primary">내용 : {{ article.articleContent }}</div>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="moveUpdate" text color="deep-purple accent-4"
          >수정</v-btn
        >
        <v-btn @click="deleteArticle" text color="deep-purple accent-4"
          >삭제</v-btn
        >
      </v-card-actions>
      <v-card-actions>
        <v-btn color="orange lighten-2" text>댓글 더보기</v-btn>
        <v-btn icon @click="show = !show">
          <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>

          <v-card-text>
            <!-- <comment-create /> -->
            <div>
              {{ writer }} 님, 댓글을 입력해주세요.
              <v-form @submit.prevent="createComment">
                <v-text-field v-model="content"></v-text-field>
                <v-btn type="submit">등록</v-btn>
              </v-form>
            </div>
            <br />
            <br />
            <div>
              <table>
                <tr>
                  <!-- <th>번호</th>
                  <v-spacer></v-spacer> -->
                  <th>작성자</th>
                  <th>내용</th>
                  <!-- <th><v-btn @click="createComment">등록</v-btn></th> -->
                </tr>
                <tr v-for="(comment, index) in comments" :key="index">
                  <!-- <td v-if="comment.commentArticleSeq == selectArticleSeq">
                    {{ index + 1 }}
                  </td> -->
                  <td v-if="comment.commentArticleSeq == selectArticleSeq">
                    <!-- {{ comment.commentSeq }}번 -->
                    {{ comment.commentWriter }}
                  </td>
                  <td v-if="comment.commentArticleSeq == selectArticleSeq">
                    {{ comment.commentContent }}
                  </td>
                  <!-- <td>
                    <v-btn @click="updateComment(comment)">수정</v-btn>
                  </td> -->
                  <v-spacer></v-spacer>
                  <td>
                    <v-btn @click="deleteComment(comment)">삭제</v-btn>
                  </td>
                </tr>
              </table>
            </div>
          </v-card-text>
        </div>
      </v-expand-transition>
    </v-card>
    <br />
    <br />
    <br />
    <br />
    <br />
  </v-container>
</template>

<script>
import { mapState } from "vuex";
// import CommentList from "../comment/CommentList.vue";

export default {
  // components: { CommentList },
  name: "ArticleDetail",
  data() {
    return {
      show: false,
      content: "",
    };
  },
  computed: {
    ...mapState(["article", "loginUser", "comments", "comment"]),
    writer: {
      get() {
        return this.loginUser;
      },
    },
    selectArticleSeq: {
      get() {
        return this.article.articleSeq;
      },
    },
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.$store.dispatch("getArticle", id);
    this.$store.dispatch("getComments", id);
  },
  methods: {
    moveUpdate() {
      this.$router.push({ name: "articleUpdate" });
    },
    deleteArticle() {
      if (confirm("정말로 삭제하시겠습니까?")) {
        // console.log(this.article.articleSeq);
        this.$store.dispatch("deleteArticle", this.article.articleSeq);
      }
    },
    createComment() {
      if (this.content === "") {
        alert("댓글 내용을 반드시 입력해야 등록이 됩니다.");
        return;
      }
      let comment = {
        commentSeq: 0,
        commentWriter: this.writer,
        commentContent: this.content,
        commentArticleSeq: this.article.articleSeq,
      };
      this.$store.dispatch("createComment", comment);
    },
    updateComment(payload) {
      this.comment = payload;
      this.$router.push({ name: "commentUpdate" });
    },
    deleteComment(payload) {
      if (this.loginUser !== payload.commentWriter) {
        alert("작성자만 삭제할 수 있습니다.");
        return;
      }
      if (confirm("정맬루 삭제하시겠습니까?")) {
        this.$store.dispatch("deleteComment", payload.commentSeq);
      }
    },
  },
};
</script>

<style></style>
