<template>
  <v-container>
    <v-card>
      <v-card-title>
        <h3>댓글 수정</h3>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-row>
            <v-col cols="12">
              <v-text-field
                label="작성자"
                readonly
                v-model="comment.commentWriter"
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-textarea
                label="내용"
                v-model="comment.commentContent"
                outlined
              ></v-textarea>
            </v-col>
            <v-col cols="12">
              <v-btn outlined @click="updateComment">수정</v-btn>
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
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "CommentUpdate",
  computed: {
    ...mapState(["comment"]),
  },
  methods: {
    updateComment() {
      let updateComment = {
        commentSeq: this.comment.comment,
        commentWriter: this.comment.commentWriter,
        commentContent: this.comment.commentContent,
        commentArticleSeq: this.comment.commentArticleSeq,
      };
      this.$store.dispatch("updateComment", updateComment);
    },
    cancelUpdate() {
      if (confirm("수정을 취소하시겠습니까?")) {
        this.$router.push(`/comment/${this.comment.commentSeq}`);
      }
    },
  },
};
</script>

<style scoped></style>
