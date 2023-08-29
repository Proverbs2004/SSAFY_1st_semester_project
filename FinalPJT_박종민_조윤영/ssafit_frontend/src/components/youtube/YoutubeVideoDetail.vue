<template>
  <div v-if="video && video.id">
    <h2>영상 보기!</h2>
    <iframe
      width="560"
      height="315"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen
    ></iframe>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'YoutubeVideoDetail',
  computed: {
    ...mapState(['video']),
    videoURL() {
      const videoId = this.video.id.videoId;
      return `https://www.youtube.com/embed/${videoId}`;
    },
  },
};
</script>

<style></style>
