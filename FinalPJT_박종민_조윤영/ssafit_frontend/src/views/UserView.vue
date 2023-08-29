<template>
  <div>

    <router-view/>
    <router-link v-if="getUser" :to="{ name: 'userList' }">유저 리스트</router-link>
    

  </div>
</template>

<script>

import { mapState} from "vuex";
export default {
  name: "UserView",

  computed: {
  
...mapState(['loginUser']),
  getUser() {
  // return !!this.loginUser;
  // if (this.loginUser.userType ==='관리자' ) {

    if (this.loginUser === "dd39") {
    return true;
  } else {
    return false;
  }
},

},

};
</script>

<style >

</style>