<template>
  <div>


    <v-container fluid>
    <v-layout row>
      <v-flex xs6 order-lg2>
        <v-card color="white">
          <v-card-text>
            <div>
              <v-btn color="white">
                <router-link :to="{ name: 'videoCreate' }">비디오 등록</router-link>
              </v-btn>
            </div>
          </v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs6>
        <v-card color="white">
          <v-card-text>
            <div>
              <v-btn color="white">
                <router-link :to="{ name: 'videoList' }">비디오 보기</router-link>
              </v-btn>
            </div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    </v-container>


    <router-view/>
    
    <!-- <router-view name="userLogin"/> -->
  </div>
</template>

<script>
export default {
  name: "VideoView",
};
</script>

<style >

</style>
