<template>
  <div>
    <v-container>
      <v-card >
        <v-toolbar color="pink" dark>
          <v-toolbar-title>목 록</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn @click="createArticle">등록</v-btn>
        </v-toolbar>

        <v-list two-line>
          <v-list-item-group>
            <template v-for="(article, index) in articles">
              <v-list-item :key="index">
                <template>
                  <v-list-item-content>
                    <v-list-item-title
                      v-text="article.articleTitle"
                    ></v-list-item-title>
                    <v-list-item-subtitle
                      v-text="article.articleBoardType"
                      class="text--primary"
                    ></v-list-item-subtitle>
                    <v-list-item-content
                      v-text="article.articleContent"
                    ></v-list-item-content>
                  </v-list-item-content>
                  <v-list-item-action>
                    <v-list-item-action-text
                      v-text="article.articleWriter"
                    ></v-list-item-action-text>

                    <router-link :to="`/board/${article.articleSeq}`">
                      <v-btn> <v-icon> mdi-magnify </v-icon> 상세보기</v-btn>
                    </router-link>
                  </v-list-item-action>
                </template>
              </v-list-item>
              <v-divider
                v-if="index < articles.length - 1"
                :key="index"
              ></v-divider>
            </template>
          </v-list-item-group>
        </v-list>
      </v-card>

      <!-- <div>
        <select v-model="mode">
          <option value="1">제목</option>
          <option value="2">내용</option>
          <option value="3">제목+내용</option>
        </select>
        <input type="text" v-model="keyword" @keyup.enter="search" />
        <button @click="search">검색</button>
      </div> -->
    </v-container>

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
  name: "ArticleList",
  data() {
    return {
      mode: 1,
      keyword: "",
    };
  },
  computed: {
    ...mapState(["articles"]),
  },
  created() {
    this.$store.dispatch("getArticles");
  },
  methods: {
    createArticle() {
      this.$router.push({ name: "articleCreate" });
    },
    search() {
      const payload = {
        mode: this.mode,
        keyword: this.keyword,
      };
      this.$store.dispatch("getArticles", payload);
    },
  },
};
</script>

<style scoped>
</style>
