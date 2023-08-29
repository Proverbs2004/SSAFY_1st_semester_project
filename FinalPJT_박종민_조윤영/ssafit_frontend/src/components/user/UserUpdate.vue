<template>
    <div>
      <h3>유저 수정</h3>
      <fieldset>
        <legend>수정</legend>
        <label for="userId">아이디 : </label>
        <input type="text" id="userId" v-model="user.userId" /><br />
        <label for="userPwd">비밀번호 : </label>
        <input type="text" id="userPwd" v-model="user.userPwd" /><br />
        <label for="writer">이름 : </label>
        <input type="text" id="writer" v-model="user.userName" /><br />
        <label for="writer">닉네임 : </label>
        <input type="text" id="writer" v-model="user.userNickname" /><br />
    
        <v-btn @click="updateUser">수정</v-btn>
      </fieldset>
    </div>
  </template>
  
  <script>
  import { mapState } from "vuex";
  
  export default {
    name: "UserUpdate",
    computed: {
      ...mapState(["user"]),
    },
    methods: {
      updateUser() {
      console.log("수정 메서드 오케이");
        let updateUser = {
          userId: this.user.userId,
          userPwd: this.user.userPwd,
          userName: this.user.userName,
          userNickname: this.user.userNickname,
        };
        this.$store.dispatch("updateUser", updateUser);
      },
    },
  };
  </script>
  
  <style></style>
  