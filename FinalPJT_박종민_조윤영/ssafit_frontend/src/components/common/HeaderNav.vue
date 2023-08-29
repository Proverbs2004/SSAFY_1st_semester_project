<template>
  <header>
    <nav>

     <v-layout row justify-space-around>



      <v-flex xs2 style="margin-right: 400px;">
        <v-card dark color="primary">
          <v-card-text>
            <div>
        <router-link to="/">
        <img src="@/assets/black.jpg" alt="GYM 로고" style="max-width: 25%;">
      </router-link>
      </div>
          </v-card-text>
        </v-card>
      </v-flex>

<!-- 
      <div>
        <router-link to="/">
        <img src="@/assets/black.jpg" alt="GYM 로고" style="max-width: 25%;">
      </router-link>
      </div> -->



   





      <v-flex xs2 style="margin-right: 400px;">
        <v-card dark color="secondary">
          <v-card-text>

          <div style="display: flex; justify-content: center;">
          
             

            <router-link to="/video">
              <v-btn id="search-button" color="black">동영상</v-btn>
            </router-link> 
            |
            <router-link :to="{ name: 'articleList' }">
              <v-btn id="search-button" color="black">커뮤니티</v-btn>
            </router-link> 


            </div>
          </v-card-text>
        </v-card>
      </v-flex>
      
      
      
      <v-flex xs2>
        <v-card dark color="accent">
          <v-card-text>
            <div style="display: flex; justify-content: center;">

              
              <a v-if="getUser" href="/" @click.prevent="logout">
                <v-btn id="search-button" color="black"><pre>
{{ loginUser }}님
로그아웃
              </pre>
              </v-btn>
              </a>
              <v-btn v-if="getUser" id="search-button" color="black" @click="myPage">마이페이지</v-btn>

              
              <router-link :to="{ name: 'userLogin' }" v-else>
                <v-btn id="search-button" color="black">로그인</v-btn>
              </router-link> 
              
              |

              <router-link :to="{ name: 'userCreate' }">
              <v-btn id="search-button" color="black">회원가입</v-btn>
              </router-link>

            </div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>




    </nav>
  </header>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "HeaderNav",
  methods: {
    logout() {
      console.log("메서드 됨");
      this.$store.dispatch("LOGOUT");
    },
    myPage() {
      this.$router.push({ name: 'myPage' });
    },  
  },
  computed: {

    ...mapState(['loginUser']),
    getUser() {
      // return !!this.loginUser;
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },

  },
};
</script>

<style scoped></style>
