const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // 开发服务器配置
  devServer: {
    host: 'localhost', // 服务器主机名
    port: 8081, // 开发服务器端口
    https: false, // 是否启用 HTTPS
    open: true, // 是否在启动时打开浏览器
  },
})
