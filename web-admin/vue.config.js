// 默认
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true
})

// monaco代码提示配置
const MonacoWebpackPlugin = require('monaco-editor-webpack-plugin');

module.exports = {
   configureWebpack: {
      plugins: [
         new MonacoWebpackPlugin()
      ]
   }
};
