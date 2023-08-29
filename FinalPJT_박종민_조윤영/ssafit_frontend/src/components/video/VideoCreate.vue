<template>
    <div class="container">

      <v-card class="mx-auto" max-width="500">
      <v-card-text>
        <v-form>
          <h2 class="text-center">비디오 등록</h2>
          <div>&nbsp;</div>
          <v-text-field
            id="title"
            type="text"
            v-model="title"
            label="비디오 제목"
            outlined
            required
            >
            <label for="title">비디오 제목</label>
        <!-- <input  id="title" v-model="title" class="view" /><br /> -->
        


          </v-text-field>
          <v-text-field
            id="url"
            v-model="url"
            label="URL"
            type="text"
            outlined
            required
          >
          <label for="url">비디오 URL</label>
        <!-- <input type="text" id="url" v-model="url" class="view" /><br /> -->
        
        </v-text-field>
          <v-text-field
            type="text"
            id="part"
            v-model="part"
            label="전신, 상체, 하체 중 입력"
            outlined
            required
          >
          <label for="part">운동 부위</label>
        <!-- <input type="part" id="part" v-model="part" class="view" /><br /> -->
        
        </v-text-field>

        </v-form>
      </v-card-text>
      <v-card-actions class="justify-center">
        <div class="centered-button">
          <v-btn color="black" @click="regist">등록</v-btn>
 
        </div>
      </v-card-actions>
    </v-card>


    


      <!-- <h2>비디오 등록</h2>
      <fieldset class="text-center">
        <label for="title">비디오 제목</label>
        <input type="text" id="title" v-model="title" class="view" /><br />
        <label for="url">비디오 URL</label>
        <input type="text" id="url" v-model="url" class="view" /><br />
        <label for="part">운동 부위</label>
        <input type="part" id="part" v-model="part" class="view" /><br />
        <button class="btn" @click="regist">등록</button>
      </fieldset> -->
    </div>
  </template>
  <script>
  export default {
    name: "UserCreate",
    data() {
      return {
        title: "",
        url: "",
        part: "",
      };
    },
    methods: {
      regist() {
        if (
          this.title === "" ||
          this.url === "" ||
          this.part === "" 
) {
          alert("모든 내용을 입력해주세요");
          return;
        }
  
        let video = {
          videoTitle: this.title,
          videoUrl: this.url,
          videoPart: this.part,

        };
        this.$store.dispatch("createVideo", video);
      },
    },
    computed: {

    },
  };
  </script>