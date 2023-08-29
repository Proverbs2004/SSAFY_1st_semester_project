<template>
  <div>

    <h3>유저 상세</h3>
    <div></div>
    <table>
      <tr>
        <td>아이디</td>
        <td>{{ user.userId }}</td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td>{{ user.userPwd }}</td>
      </tr>
      <tr>
        <td>이름</td>
        <td>{{ user.userName }}</td>
      </tr>
      <tr>
        <td>닉네임</td>
        <td>{{ user.userNickname }}</td>
      </tr>
    </table>
    <button @click="moveUpdate">수정</button>
    <button @click="deleteArticle">삭제</button>


<br>
<br>
<br>
<br>
<br>

    <div>
        <table class="user-list">
          <thead>
            <tr>
              <th>비디오 제목</th>
              <th>URL</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(video, index) in videos" :key="index">
              <td>{{ index + 1 }}</td>
              <td>
                {{ video.videoTitle }}
              </td>
              <td>{{ video.videoUrl }}</td>

            </tr>
          </tbody>
        </table>
      </div>
    








  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserDetail",
  computed: {
    ...mapState(["loginUser"]),
    ...mapState(["user"]),
    ...mapState(["videos"]),
  },
  created() {
    console.log(this.loginUser);
    this.$store.dispatch("getUser", this.loginUser);

    this.$store.dispatch("getWishList", this.loginUser)


  },
  methods: {
    moveUpdate() {
      this.$router.push({ name: "userUpdate" });
    },
    deleteArticle() {
      if(confirm("정말로 삭제하시겠습니까?")){
        // console.log(this.article.articleSeq);
        this.$store.dispatch("deleteUser", this.user.userId);
      }
    },
  },
};
</script>

<style></style>