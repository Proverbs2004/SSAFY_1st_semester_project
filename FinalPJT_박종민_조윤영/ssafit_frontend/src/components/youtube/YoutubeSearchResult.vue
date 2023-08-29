<!-- <template>
  <div>
    <h3>검색 결과</h3>
    <ul class="youtube-list">
      <youtube-video-item
        v-for="video in videos"
        :key="video.id.videoId"
        :video="video"
      ></youtube-video-item>
    </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import YoutubeVideoItem from './YoutubeVideoItem.vue';

export default {
  components: { YoutubeVideoItem },
  name: 'YoutubeSearchResult',
  computed: {
    ...mapState(['videos']),
  },
};
</script>

<style scoped>
.youtube-list {
  text-align: left;
}
</style> -->
<template>
  <div class="youtube-search-result">
    <h3 class="result-title">검색 결과</h3>
    <ul class="youtube-list">
      <li v-for="video in videos" :key="video.id.videoId" class="youtube-item">
        <youtube-video-item :video="video"></youtube-video-item>
      </li>
    </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import YoutubeVideoItem from './YoutubeVideoItem.vue';

export default {
  components: {
    YoutubeVideoItem
  },
  name: 'YoutubeSearchResult',
  computed: {
    ...mapState(['videos'])
  }
};
</script>

<style scoped>
.youtube-search-result {
  text-align: left;
}

.result-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.youtube-list {
  list-style: none;
  padding: 0;
}

.youtube-item {
  margin-bottom: 1rem;
}
</style>
