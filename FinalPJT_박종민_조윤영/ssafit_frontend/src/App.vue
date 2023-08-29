<!-- <template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script> -->


<template>
  
  <div id="app" class="background">

    <v-container grid-list-md text-xs-center>
  <v-layout row wrap>

    

  <!-- 맨 위에-->
    <v-flex xs12>
      <v-card style="background-color: black; height: 150px;">
        <v-card-text class="px-0">
          <div>
          <header-nav></header-nav>
          </div>
        </v-card-text>
      </v-card>
    </v-flex>
    <!-- 맨 위에 끝 -->


    <!-- 카로설 시작-->
    <v-carousel>
  <v-carousel-item
    v-for="(item,i) in items"
    :key="i"
    :src="item.src"
    reverse-transition="fade"
    transition="fade"
    @click="moveToEvent">

  </v-carousel-item>
  </v-carousel>



      <!-- 카로설 끝 -->
       <v-flex xs12>
        <v-card dark color="primary">
          <v-card-text class="px-0">
            <div style="display: flex; justify-content: center;">
              <router-link to="/youtube">
                <v-btn color="black">Youtube에 검색하러 가기</v-btn>
              </router-link>
            </div>
          </v-card-text>
        </v-card>
      </v-flex>



    
      </v-layout>
      </v-container>

    <div class="footer-container">
          <router-view/>
          <footer-nav></footer-nav>
    </div>
      
    </div>

  </template>


<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import FooterNav from "@/components/common/FooterNav.vue";



export default {

  components: {
    HeaderNav,
    FooterNav,

  },
  data () {
      return {
        items: [
          {
            src: require("@/assets/images/basketball-player.jpg")
          },
          {
            src: require("@/assets/images/iso-republic-road-bike-handlebars.jpg")
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg'
          }
        ]
      }
    },
    methods: {
  moveToEvent() {
    if (this.$route.path !== '/event') { // 현재 경로와 이동하려는 경로가 다른 경우에만 실행
      console.log("무브투 실행");
      this.$router.push("/event");
    }
  }
},
created() {
    this.showYoutubeSearch = true; 
  },
};
</script>

<style scoped>



.footer-nav {
  position: fixed;
  bottom: 0;
  width: 100%;

}




.background{
  overflow: hidden;
  margin:0;

  /* background-image: url("./assets/background.jpg"); */
  /* background-color: black; */
  background-color: white;
  background-size: cover;
  background-repeat: no-repeat;

  background-position: center;
  position: relative; 

}
.footer-container {
  display: flex;
  justify-content: center;
  align-items: center;
  /* margin-top: 20px; */


  width:100%;
  /* width : 100vw; */
 } 



</style>

    



