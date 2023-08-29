<template>
  <li @click="clickVideo">
    <img :src="video.snippet.thumbnails.default.url" />
    {{ video.snippet.title }}
  </li>
</template>

<script>
export default {
  name: 'YoutubeVideoItem',
  props: {
    video: {
      type: Object,
      required: true,
    },
  },
  methods: {
    clickVideo() {
      this.$store.dispatch('clickVideo', this.video);
    },
  },
};
</script>

<style></style>
