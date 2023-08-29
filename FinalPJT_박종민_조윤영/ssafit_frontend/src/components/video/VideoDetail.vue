<template>
    
    <div>

      <div>영상 이름 : {{ video.videoTitle }}</div>
      <div>운동 부위 : {{ video.videoPart }}</div> 
      <iframe
        width="560"
        height="315"
        :src="videoURL"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
      ></iframe>

      <div>조회수 : {{ video.videoViewcnt }}</div>
      <div v-if="Visible">
        <v-btn color ="black" density="comfortable" icon="mdi-vuetify" @click="like">♡</v-btn>
      </div>
      <div v-else>
        <v-btn color ="black" density="comfortable" icon="mdi-vuetify" @click="dislike">❤</v-btn>
      </div>


      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>

    </div>
  </template>
  
  <script>
  import { mapState } from 'vuex';
  export default {
    data(){
      return {
        Visible: true,
      }
    },

    

    name: 'VideoDetail',
    computed: {
      ...mapState(['video']),
      ...mapState(['loginUser']),
      videoURL() {


        const videoId = this.video.videoUrl;

        const path = videoId.split("/");

        const videoInputUrl = path[path.length-1];
        console.log(videoInputUrl);
        const url = videoInputUrl.substring(8);
        console.log(url);
        return `https://www.youtube.com/embed/${url}`;


        
      },
      
    },
    created() {
      



      
      const pathName = new URL(document.location).pathname.split("/");
      const title = pathName[pathName.length-1];
      this.$store.dispatch("getVideo", String(title));
    },
    mounted() {
      
      
    },
    methods: {
      deleteArticle() {
        if(confirm("정말로 삭제하시겠습니까?")){
          // console.log(this.article.articleSeq);
          this.$store.dispatch("deleteVideo", this.video.videoTitle);
        }
      },
      like() {

        let wishList = {
          wishSeq: 0,
          userId: this.loginUser,
          videoSeq: this.video.videoSeq,
        }
        console.log("라이크");
        this.Visible = false;
        console.log(this.video.videoSeq);
        this.$store.dispatch("likeVideo", wishList);

      },
      dislike(){
        this.Visible = true;
        console.log("디스라이크");
        
      }
     
    },

  };

 
  </script>
  
  <style></style>