import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

// npm install vuex-persistedstate 먼저하기
// npm install --save vue-good-table 이것도 설치
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

// const REST_API = `http://localhost:8080/api`;
const REST_API_BOARD = `http://localhost:8080/api-board`;
const REST_API_COMMENT = `http://localhost:8080/api-comment`;
const REST_API_USER = `http://localhost:8080/api-user`;
const REST_API_VIDEO = `http://localhost:8080/api-video`;
const REST_API_WiSH = `http://localhost:8080/api-wish`;
export default new Vuex.Store({
  plugins: [createPersistedState()],

  state: {
    articles: [],
    article: {},
    comments: [],
    comment: {},
    // selectComments: [],
    // selectArticleSeq: 0,

    users: [],
    user: {},
    loginUser: null,
    videos: [],
    video: {},

    wishLists:[],
    wishList: {},
  },
  getters: {},
  mutations: {
    GET_ARTICLES(state, articles) {
      state.articles = articles;
    },
    GET_ARTICLE(state, article) {
      state.article = article;
    },
    CREATE_ARTICLE(state, article) {
      state.articles.push(article);
    },
    UPDATE_ARTICLE(state, article) {
      state.article = article;
    },

    SELECT_ARTICLE: function (state, payload) {
      state.selectArticleSeq = payload;
    },

    GET_COMMENTS(state, payload) {
      state.comments = payload;
    },
    CREATE_COMMENT(state, payload) {
      state.comments.push(payload);
    },
    UPDATE_COMMENT(state, payload) {
      state.comment = payload;
    },
    GET_WISHLISTS(state, payload) {
      state.wishLists = payload;
    },
    GET_WISHLIST(state, payload) {
      state.wishList = payload;
    },
    CREATE_WISHLIST(state, payload) {
      state.wishLists.push(payload);
    },

    GET_USERS(state, payload) {
      state.users = payload;
    },
    GET_USER(state, payload) {
      state.user = payload;
    },
    CREATE_USER(state, payload) {
      state.users.push(payload);
    },
    UPDATE_USER(state, payload) {
      state.user = payload;
    },
    LOGOUT(state) {
      state.loginUser = null;
      console.log("null 됨");
      console.log("state.loginUser");
    },
    SET_LOGIN_USER: function (state, payload) {
      state.loginUser = payload;
    },

    GET_VIDEOS(state, payload) {
      state.videos = payload;
    },
    GET_VIDEO(state, payload) {
      state.video = payload;
    },
    CREATE_VIDEO(state, payload) {
      state.videos.push(payload);
    },
    SEARCH_YOUTUBE(state, videos) {
      state.videos = videos;
    },
    CLICK_VIDEO(state, video) {
      state.video = video;
    },
    VIEWCNT_VIDEO(state, video) {
      state.video = video;
    },
  },
  actions: {
    getArticles({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API_BOARD}/selectAll`;
      axios({
        url: API_URL,
        method: "GET",
        params,
        // headers: {
        //   "access-token": sessionStorage.getItem("access-token"),
        // },
      })
        .then((res) => {
          // console.log(res);
          commit("GET_ARTICLES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getArticle({ commit }, id) {
      const API_URL = `${REST_API_BOARD}/board/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          commit("GET_ARTICLE", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createArticle({ commit }, article) {
      const API_URL = `${REST_API_BOARD}/upload`;
      // console.log(article);
      axios({
        url: API_URL,
        method: "POST",
        // headers: {
        //   "Content-Type": "application/json",
        // },
        data: {
          articleSeq: article.articleSeq,
          articleTitle: article.articleTitle,
          articleWriter: article.articleWriter,
          articleContent: article.articleContent,
          articleBoardType: article.articleBoardType,
        },
      })
        .then(() => {
          commit("CREATE_ARTICLE", article);
          router.push("/board");
          // console.log(this.$store.state.boards);
          alert("게시글 등록 완료!");
        })
        .catch((err) => {
          console.log(err);
          alert("등록 에러! 스프링이나 개발자모드 확인 필!");
        });
    },
    updateArticle({ commit }, article) {
      const API_URL = `${REST_API_BOARD}/update`;
      // console.log("여기까지왔음");
      // console.log(API_URL);
      axios({
        url: API_URL,
        method: "PUT",
        params: article,
      }).then(() => {
        commit("UPDATE_ARTICLE", article);
        router.push({
          name: "articleDetail",
          params: { id: article.articleSeq },
        });
        alert("수정이 완료되었습니다!");
      });
    },
    deleteArticle({ commit }, id) {
      const API_URL = `${REST_API_BOARD}/board/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          alert("삭제가 완료되었습니다!");
          commit;
          router.push({ name: "ArticleList" });
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getComments({ commit }, id) {
      // let params = null;
      // if (payload) params = payload;

      const API_URL = `${REST_API_COMMENT}/${id}`;
      axios({
        url: API_URL,
        method: "GET",
        // params,
      })
        .then((res) => {
          console.log("댓글리스트 확인중");
          console.log(res);
          commit("GET_COMMENTS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createComment({ commit }, comment) {
      const API_URL = `${REST_API_COMMENT}/upload`;
      axios({
        url: API_URL,
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          commentSeq: comment.commentSeq,
          commentContent: comment.commentContent,
          commentWriter: comment.commentWriter,
          commentArticleSeq: comment.commentArticleSeq,
        },
      })
        .then(() => {
          commit("CREATE_COMMENT", comment);
          // router.push("/:redirect"); 새로고침 하는ㄴ거찾아보기
          alert("댓글 등록 완료!");
        })
        .catch((err) => {
          console.log(err);
          alert("댓글 등록 에러! 스프링이나 개발자모드 확인 필!");
        });
    },
    updateComment({ commit }, comment) {
      const API_URL = `${REST_API_COMMENT}/update`;
      axios({
        url: API_URL,
        method: "PUT",
        params: comment,
      }).then(() => {
        commit("UPDATE_COMMENT", comment);
      });
    },
    deleteComment({ commit }, id) {
      const API_URL = `${REST_API_COMMENT}/comment/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          commit;
          alert("삭제가 완료되었습니다!");
          // router.push({ name: "CommentList" });
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getUsers({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API_USER}/list`;
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
        .then((res) => {
          commit("GET_USERS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getUser({ commit }, userId) {
      console.log(userId);
      console.log(userId);
      const API_URL = `${REST_API_USER}/${userId}`;
      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          userId: userId.data,
        },
      })
        .then((res) => {
          console.log(res);
          commit("GET_USER", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createUser({ commit }, user) {
      const API_URL = `${REST_API_USER}/signup`;

      axios({
        url: API_URL,
        method: "POST",
        // params: user,
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          userId: user.userId,
          userPwd: user.userPwd,
          userName: user.userName,
          userNickname: user.userNickname,
        },
      })
        .then(() => {
          commit("CREATE_USER", user);
          router.push("/");
          alert("회원가입이 완료 되었습니다. 감사합니다.");
        })
        .catch((err) => {
          console.log(err);
          alert("회원가입이 완료되지 않았습니다.");
        });
    },
    updateUser({ commit }, updateUser ) {
      const API_URL = `${REST_API_USER}/update`;
      console.log("유저수정");
      console.log(updateUser );
      axios({
        url: API_URL,
        method: "PUT",
        data:{
          userId: updateUser .userId,
          userPwd: updateUser .userPwd,
          userName: updateUser .userName,
          userNickname: updateUser .userNickname,

        }
      }).then(() => {
        commit("UPDATE_USER", updateUser );
        router.push({ name: "userDetail", params: { id: updateUser .id } });
      });
    },
    deleteUser({ commit }, userId) {
      const API_URL = `${REST_API_USER}/delete/${userId}`;
      axios({
        url: API_URL,
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          userId: userId,
        },
      })
        .then(() => {
          commit;
          router.push({ name: "userList" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    userLogin({ commit }, user) {
      const API_URL = `${REST_API_USER}/login`;
      axios({
        url: API_URL,
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          userId: user.userId,
          userPwd: user.password,
        },
      })
        .then((res) => {
          console.log(res);
          sessionStorage.setItem("access-token", res.data["access-token"]);
          const token = sessionStorage.getItem("access-token");

          const tokenPayload = token.split(".")[1]; // 토큰의 payload 부분만 추출

          const decodedPayload = JSON.parse(atob(tokenPayload)); // payload 디코딩 후 파싱

          const userId = decodedPayload.userId; //

          // commit("SET_LOGIN_USER", res.data.user);
          commit("SET_LOGIN_USER", userId); // 여기 id만 넣는거말고 res.data로 유저 전체 넣는거로 바꾸기가능? 로그인 유저닉네임 필요해서..
          alert("로그인이 되었습니다.");
          router.push("/");
        })
        .catch((err) => {
          console.log(err);
          alert("로그인에 실패하였습니다. 아이디나 비밀번호를 확인해 주세요.");
        });
    },
    getVideos({ commit }, payload) {
      let params = null;
      if (payload) params = payload;
      const API_URL = `${REST_API_VIDEO}/selectAll`;
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
        .then((res) => {
          commit("GET_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getVideo({ commit }, videoTitle) {
      const API_URL = `${REST_API_VIDEO}/${videoTitle}`;
      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          videoTitle: videoTitle,
        },
      })
        .then((res) => {
          commit("GET_VIDEO", res.data);
        })

        .catch((err) => {
          console.log(err);
        });
    },
    createVideo({ commit }, video) {
      const API_URL = `${REST_API_VIDEO}/upload`;

      axios({
        url: API_URL,
        method: "POST",

        headers: {
          "Content-Type": "application/json",
        },
        data: {
          videoTitle: video.videoTitle,
          videoUrl: video.videoUrl,
          videoPart: video.videoPart,
        },
      })
        .then(() => {
          commit("CREATE_VIDEO", video);
          router.push("/video");
          alert("비디오 등록이 완료 되었습니다. 감사합니다.");
        })
        .catch((err) => {
          console.log(err);
          alert("비디오 등록이 완료되지 않았습니다.");
        });
    },
    // 이거 이름 비디오로 수정해야될듯? -> 일단내가수정함
    deleteVideo({ commit }, videoTitle) {
      const API_URL = `${REST_API_VIDEO}/delete/${videoTitle.videoTitle}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          commit;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchYoutube({ commit }, payload) {
      const VUE_APP_YOUTUBE_API_KEY = "AIzaSyCIctM0H6wH996HwaNBaVePcvT_i5Vv50g";
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = VUE_APP_YOUTUBE_API_KEY;
      axios({
        url: URL,
        method: "GET",
        params: {
          key: API_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResults: 10,
        },
      })
        .then((res) => {
          commit("SEARCH_YOUTUBE", res.data.items);
        })
        .catch((err) => console.log(err));
    },
    //payload : 비디오 객체가 들어온다.
    clickVideo({ commit }, payload) {
      commit("CLICK_VIDEO", payload);
    },
    LOGOUT({ commit }) {
      commit("LOGOUT");
      console.log("actions 됨");
    },
    viewCnt({ commit }, video) {
      const API_URL = `${REST_API_VIDEO}/viewCnt`;
      console.log("룰루");
      console.log(video);
      console.log("2");
      axios({
        url: API_URL,
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          videoTitle: video.videoTitle,
          videoViewcnt: video.videoViewcnt,
        },
      })
        .then((video) => {
          console.log(video);
          commit("VIEWCNT_VIDEO", video);
          console.log(this.video.videoViewcnt);
          console.log("비디오 조회수 전달 받았따");
        })
        .catch((err) => {
          console.log(err);
          console.log("비디오 조회수 전달 못 받았다");
        });
    },

    likeVideo({ commit }, wishList){
      
      const API_URL = `${REST_API_WiSH}/like`;


      axios({
        url: API_URL,
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
  
        data: {
          wishSeq: wishList.wishList,
          userId: wishList.userId,
          videoSeq: wishList.videoSeq,
        },
      })
        .then(() => {
          commit("CREATE_WISHLIST", wishList);

        })
        .catch((err) => {
          console.log(err);
        });
    },
    getWishList({ commit }, userId){
      
      const API_URL = `${REST_API_WiSH}/list/${userId}`;
      axios({
        url: API_URL,
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },

        data: {

          userId: this.userId,
  
        },
      })
        .then((res) => {
          commit("GET_VIDEOS",res.data);


        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
