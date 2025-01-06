import { createRouter, createWebHistory } from 'vue-router'; // Vue 3 的路由初始化
import Index from '../views/Index.vue';
import BusinessList from '../views/BusinessList.vue';
import BusinessInfo from '../views/BusinessInfo.vue';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';
import Order from '../views/Order.vue';
import Payment from '../views/Payment.vue';
import OrderList from '../views/OrderList.vue';

// 路由配置数组
const routes = [
  {
    path: '/',
    name: 'index',
    component: Login,
  },
  {
    path: '/index',
    name: 'Index',
    component: Index,
  },
  {
    path: '/businessList',
    name: 'BusinessList',
    component: BusinessList,
  },
  {
    path: '/businessInfo',
    name: 'BusinessInfo',
    component: BusinessInfo,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
  },
  {
    path: '/order',
    name: 'Order',
    component: Order,
  },
  {
    path: '/payment',
    name: 'Payment',
    component: Payment,
  },
  {
    path: '/orderlist',
    name: 'OrderList',
    component: OrderList,
  },
];

// 创建路由实例
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), // 使用 HTML5 History 模式
  routes,
});

// 修复 Vue Router 4 中重复路由报错问题
const originalPush = router.push;
router.push = function push(location) {
  return originalPush.call(this, location).catch((error) => error);
};

export default router;
