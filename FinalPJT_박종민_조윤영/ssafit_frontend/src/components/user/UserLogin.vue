<template>
    <div>

      <div>

        <!-- 로그인 입력 시작 -->
        <div id="app" >
  <v-app id="inspire" >
    <v-card
      class="hide-overflow"
      color="grey lighten-1"
      dark
    >
      <v-toolbar
        card
        color="grey darken-4"
      >
        <v-icon>mdi-account</v-icon>
        <v-toolbar-title class="font-weight-light" >로그인</v-toolbar-title>
        <v-spacer></v-spacer>
        
      </v-toolbar>
      <v-card-text>
 
        <input type="text" v-model.trim="user.userId" placeholder="아이디를 입력해 주세요"><br>
        <br>

        <input type="password" v-model.trim="user.password" placeholder="비밀번호를 입력해 주세요">
 
    
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-spacer></v-spacer>

        <v-btn color="black" @click="login">로그인</v-btn>

      </v-card-actions>
    </v-card>
  </v-app>
</div>
        
<!-- 로그인 입력 끝-->



<!-- 
          <input type="text" v-model.trim="user.userId" placeholder="아이디를 입력해 주세요">
          <input type="password" v-model.trim="user.password" placeholder="비밀번호를 입력해 주세요">
          <button @click="login">로그인</button> -->
      </div>
    </div>
  </template>
  
  <script>
  export default {

      name: "UserLogin",
      data() {
          return {
              user : {
                  userId: "",
                  password: ""
              },
              hasSaved: false,
      isEditing: null,
      model: null,
      
    };
  },
  methods: {
    customFilter(item, queryText) {
      const textOne = item.name.toLowerCase();
      const textTwo = item.abbr.toLowerCase();
      const searchText = queryText.toLowerCase();

      return (
        textOne.indexOf(searchText) > -1 || textTwo.indexOf(searchText) > -1
      );
    },
          login(){
              this.$store.dispatch('userLogin', this.user)
          }
      },
  }
 


  </script>
  
  <style scoped>
  input {
  width: 500px;
  height: 32px;
  font-size: 15px;
  border: 0;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
}
  
  </style>