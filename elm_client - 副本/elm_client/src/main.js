import { createApp } from 'vue'; // Vue 3 的入口方法
import App from './App.vue';
import router from './router';
import 'font-awesome/css/font-awesome.min.css';
import axios from 'axios';
import qs from 'qs';
// 创建 Vue 3 应用实例
const app = createApp(App);

// 配置 axios 的基础 URL
axios.defaults.baseURL = 'http://localhost:8080/';

// 将 axios 和 qs 挂载到全局实例上
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$qs = qs;

// 挂载路由和应用实例
app.use(router).mount('#app');
