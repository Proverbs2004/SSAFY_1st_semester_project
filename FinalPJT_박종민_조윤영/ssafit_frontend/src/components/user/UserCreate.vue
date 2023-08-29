<template>
  
  <div class="container">
    
    
    <v-card class="mx-auto" max-width="500">
      <v-card-text>
        <v-form>
          <h2 class="text-center">회원 가입</h2>
          <div>&nbsp;</div>
          <v-text-field
            v-model="id"
            label="아이디"
            outlined
            required
          ></v-text-field>
          <v-text-field
            v-model="password"
            label="비밀번호"
            type="password"
            outlined
            required
          ></v-text-field>
          <v-text-field
            v-model="name"
            label="이름"
            outlined
            required
          ></v-text-field>
          <v-text-field
            v-model="nickname"
            label="닉네임"
            outlined
            required
          ></v-text-field>
        </v-form>
      </v-card-text>
      <v-card-actions class="justify-center">
        <div class="centered-button">
          <v-btn color="black" @click="regist">등록</v-btn>
        </div>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "UserCreate",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      nickname: "",
    };
  },
  methods: {
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.nickname === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        userId: this.id,
        userPwd: this.password,
        userName: this.name,
        userNickname: this.nickname,
      };

      this.$store.dispatch("createUser", user);
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
}

.text-center {
  text-align: center;
}

/* .mx-auto {
  margin-left: auto;
  margin-right: auto;
} */

.max-width {
  max-width: 500px;
}

.v-card-text {
  padding: 24px;
}

.v-card-actions {
  padding: 16px;
}

.v-card-text {
  color: black;
}

.centered-button {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>
