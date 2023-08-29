<template>
  <v-container>
    <v-card>
      <v-card-title>
        <h3>게시글 수정</h3>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-row>
            <v-col cols="12">
              <v-text-field
                label="제목"
                v-model="article.articleTitle"
                @keyup.enter="updateArticle"
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field
                label="작성자"
                readonly
                v-model="article.articleWriter"
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              게시판 종류
                <select v-model="article.articleBoardType">
                  <option value="운동루틴">운동루틴</option>
                  <option value="식단">식단</option>
                  <option value="지역">지역</option>
                  <option value="자유">자유</option>
                  <option value="상담">상담</option>
                </select>              
              <!-- <v-select
                :items="items"
                v-model="article.articleBoardType"
                outlined
              >
              </v-select> -->
            </v-col>
            <v-col cols="12">
              <v-textarea
                label="내용"
                v-model="article.articleContent"
                outlined
                no-resize
              ></v-textarea>
            </v-col>
            <!-- 작성자와 로그인 유저가 같을떄만 수정버튼 나오게 한다. -->
            <v-col cols="12">
              <v-btn outlined @click="updateArticle">수정</v-btn>
              <v-btn outlined @click="cancelUpdate">취소</v-btn>
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
    </v-card>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
  </v-container>

  <!--
  <div>
    <h3>게시글 수정</h3>
    <fieldset>
      <legend>수정</legend>
      <label for="title">제목 : </label>
      <input type="text" id="title" v-model="article.title" required /><br />
      <label for="writer">작성자 : </label>
      <input type="text" id="writer" v-model="article.writer" readonly /><br />
      <label for="type">구분 : </label>
      <select id="type" v-model="article.type">
        <option value="운동루틴">운동루틴</option>
        <option value="식단">식단</option>
        <option value="지역">지역</option>
        <option value="자유">자유</option>
        <option value="상담">상담</option>
      </select>
      <label for="content">내용 : </label>
      <textarea
        id="content"
        col="30"
        rows="20"
        v-model="article.content"
        required
      ></textarea>
      <button @click="updateArticle">수정</button>
      <button @click="cancelUpdate">취소</button>
    </fieldset>
  </div-->
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ArticleUpdate",
  data() {
    return {
      items: ["운동루틴", "식단", "지역", "자유", "상담"],
    };
  },
  computed: {
    ...mapState(["article"]),
  },
  methods: {
    updateArticle() {
      let updateArticle = {
        articleSeq: this.article.articleSeq,
        articleTitle: this.article.articleTitle,
        articleWriter: this.article.articleWriter,
        articleContent: this.article.articleContent,
        articleBoardType: this.article.articleBoardType,
      };
      // console.log(updateArticle); 잘들어갔음
      this.$store.dispatch("updateArticle", updateArticle);
    },
    cancelUpdate() {
      if (confirm("수정을 취소하시겠습니까?")) {
        this.$router.push(`/board/${this.article.articleSeq}`);
      }
    },
  },
};
</script>

<style scoped></style>
