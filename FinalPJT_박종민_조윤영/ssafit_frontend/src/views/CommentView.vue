<template>
  <div>
    <h2>댓글 뷰</h2>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "CommentView",
};
</script>

<style scoped>
.background {
  height: 100vh;
  overflow: hidden;
  margin: 0;
  background-color: white;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
</style>
