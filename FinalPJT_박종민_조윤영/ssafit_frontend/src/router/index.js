import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import BoardView from "../views/BoardView.vue";
import CommentView from "../views/CommentView.vue";
import UserView from "../views/UserView.vue";
import VideoView from "../views/VideoView.vue";
import YoutubeView from "../views/YoutubeView.vue";

import ArticleCreate from "../components/board/ArticleCreate.vue";
import ArticleList from "../components/board/ArticleList.vue";
import ArticleDetail from "../components/board/ArticleDetail.vue";
import ArticleUpdate from "../components/board/ArticleUpdate.vue";
import CommentUpdate from "../components/comment/CommentUpdate.vue";

import UserCreate from "../components/user/UserCreate.vue";
import UserDetail from "../components/user/UserDetail.vue";
import UserList from "@/components/user/UserList.vue";
import UserUpdate from "../components/user/UserUpdate.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import VideoList from "@/components/video/VideoList.vue";
import VideoDetail from "@/components/video/VideoDetail.vue";
import VideoCreate from "@/components/video/VideoCreate.vue";
import moveToEventPage from "@/components/event/EventPage.vue";
import moveToMyPage from "@/components/user/MyPage.vue"
// import { component } from "vue/types/umd";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/board",
    component: BoardView,
    children: [
      {
        path: "",
        name: "articleList",
        component: ArticleList,
      },
      {
        path: "create",
        name: "articleCreate",
        component: ArticleCreate,
      },
      {
        path: ":id",
        name: "articleDetail",
        component: ArticleDetail,
      },
      {
        path: "update",
        name: "articleUpdate",
        component: ArticleUpdate,
      },
    ],
  },
  {
    path: "/comment",
    component: CommentView,
    children: [
      {
        path: "update",
        name: "commentUpdate",
        component: CommentUpdate,
      },
    ],
  },

  {
    path: "/video",
    component: VideoView,
    children: [
      {
        path: "",
        name: "videoList",
        component: VideoList,
      },
      {
        path: "create",
        name: "videoCreate",
        component: VideoCreate,
      },
      {
        path: ":videoTitle",
        name: "videoDetail",
        component: VideoDetail,
      },
    ],
  },
  {
    path: "/user",
    component: UserView,
    children: [
      {
        path: "",
        name: "userList",
        component: UserList,
        // meta: { requiresAuth: true },
      },
      {
        path: "create",
        name: "userCreate",
        component: UserCreate,
      },
      {
        path: ":userId",
        name: "userDetail",
        component: UserDetail,
      },
      {
        path: "update",
        name: "userUpdate",
        component: UserUpdate,
      },
      {
        path: "login",
        name: "userLogin",
        component: UserLogin,
      },
      {
        path: "/",
        redirect: "/login",
      },
      {
        path: "myPage",
        name: "myPage",
        component: moveToMyPage,
      },
    ],
  },
  {
    path: "/youtube",
    name: "youtube",
    component: YoutubeView,
  },
  {
    path: "/event",
    name: "event",
    component: moveToEventPage,
  },
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
