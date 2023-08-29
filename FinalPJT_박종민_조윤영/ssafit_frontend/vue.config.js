const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: [
    'vuetify'
  ]
})
module.exports = {
  devServer: {
    port: 9999
  },

  transpileDependencies: [
    'vuetify'
  ]
};


