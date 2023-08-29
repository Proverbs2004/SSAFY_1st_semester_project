<template>
  <div class="container">
    <h2>저장된 영상 목록</h2>
    <div>
      <table class="user-list">
        <thead>
          <tr>
            <th>영상 이름</th>
            <th>운동 부위</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(video, index) in videos" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link :to="`/video/${video.videoTitle}`" @click="viewUp">
                {{ video.videoTitle }}
              </router-link>
            </td>
            <td>{{ video.videoPart }}</td>
            <div>
              <v-btn color="black" @click="deleteVideo(video)">삭제</v-btn>
            </div>
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
  name: "VideoList",
  data() {
  return {
    keyword: "",
  };
},
computed: {
  ...mapState(["videos"]),
},
created() {
  this.$store.dispatch("getVideos");
},
methods: {
  viewUp(){
    console.log("마지막 시도");
      console.log(this.video);
      this.$store.dispatch("viewCnt", this.video);
  },

deleteVideo(video){

  this.$store.dispatch("deleteVideo", video);

}
  },
};
</script>

<style>

</style>