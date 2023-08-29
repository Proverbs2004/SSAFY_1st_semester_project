<template>
  <div>
    <v-card>
      <v-card-title>
        <h3>게시글 등록</h3>
      </v-card-title>
      <v-card-text>
        <v-form @submit.prevent="createArticle">
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="title" label="제목"></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  v-model="writer"
                  label="작성자"
                  readonly
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <!-- <v-combobox
                v-model="type"
                :items="items"
                label="게시판 종류"
              ></v-combobox> -->
                게시판 종류
                <!-- <v-select :items="items" v-model="type" outlined> </v-select> -->
                <select v-model="type">
                  <option value="운동루틴">운동루틴</option>
                  <option value="식단">식단</option>
                  <option value="지역">지역</option>
                  <option value="자유">자유</option>
                  <option value="상담">상담</option>
                </select>
              </v-col>
              <v-col cols="12">
                <v-textarea
                  v-model="content"
                  label="내용"
                  outlined
                  no-resize
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-btn type="submit" color="">등록</v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-form>
      </v-card-text>
    </v-card>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "ArticleCreate",
  data() {
    return {
      title: "",
      content: "",
      type: "자유",
      items: ["운동루틴", "식단", "지역", "자유", "상담"],
    };
  },
  computed: {
    ...mapState(["loginUser"]),
    writer: {
      get() {
        return this.loginUser;
      },
    },
  },
  methods: {
    createArticle() {
      if (this.title === "" || this.content === "") {
        alert("제목이나 내용은 반드시 입력해야 합니다.");
        return;
      }
      let article = {
        articleSeq: 0,
        articleTitle: this.title,
        articleWriter: this.writer,
        articleContent: this.content,
        articleBoardType: this.type,
      };
      this.$store.dispatch("createArticle", article);
    },
  },
};
</script>

<style scoped></style>
