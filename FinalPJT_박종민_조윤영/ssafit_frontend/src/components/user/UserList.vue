<template>
    <div class="container">
      <h2>사용자 목록</h2>
      <!-- <h4>등록된 사용자의 수 : {{ userCnt }}</h4> -->
      <!-- <div v-if="userCnt"> -->
      <div>
        <table class="user-list">
          <thead>
            <tr>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>이름</th>
              <th>닉네임</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(user, index) in users" :key="index">
              <td>{{ index + 1 }}</td>
              <td>
                <router-link :to="`/user/${user.userId}`">
                {{ user.userId }}</router-link>
              </td>
              <td>{{ user.userPwd }}</td>
              <td>{{ user.userName }}</td>
              <td>{{ user.userNickname }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- <div v-else>등록된 사용자가 없습니다.</div> -->
    </div>
  </template>
  <script>
    // import { mapState, mapGetters } from "vuex";
  import { mapState} from "vuex";
  export default {
    name: "UserList",
    data() {
    return {
      keyword: "",
    };
  },
  computed: {
    ...mapState(["users"]),
  },
  created() {
    this.$store.dispatch("getUsers");
  },
  methods: {
   
    },
  };
  </script>

  <style>

</style>