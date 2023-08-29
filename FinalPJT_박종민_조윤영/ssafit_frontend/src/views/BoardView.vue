<template>
  <div>
    <h2>SSAFIT 게시판</h2>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "BoardView",
};
</script>

<style scoped>
  .background{
  height: 100vh;
  overflow: hidden;
  margin:0;
  background-color: white;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
</style>
