<template>
  <div class="search-container">
    <h3 class="search-title">유튜브 검색을 통해 원하는 운동을 찾아보세요</h3>
    <div class="search-input-container">
      <input type="text" v-model="keyword" class="search-input" placeholder="검색어를 입력하세요" />
      <button @click="search" class="search-button">검색</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'YoutubeSearch',
  data() {
    return {
      keyword: '',
    };
  },
  methods: {
    search() {
      this.$store.dispatch('searchYoutube', this.keyword);
    },
  },
};
</script>

<style scoped>
.search-container {
  text-align: center;
  padding: 20px;
  background-color: #f8f8f8;
}

.search-title {
  font-size: 24px;
  margin-bottom: 10px;
}

.search-input-container {
  display: flex;
  align-items: center;
  justify-content: center;
}

.search-input {
  width: 300px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-right: 10px;
}

.search-button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-button:hover {
  background-color: #0056b3;
}

.search-button:active {
  background-color: #003c80;
}
</style>
