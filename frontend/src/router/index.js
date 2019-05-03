import Vue from 'vue';
import Router from 'vue-router'; // eslint-disable-next-line
import store from '@/store';

Vue.use(Router);

const router = new Router({
  routes: [
    {
      name: 'login',
      path: '/login',
      component: () => import('@/pages/login/Login'),
    },
    {
      name: 'register',
      path: '/register',
      component: () => import('@/pages/register/Register'),
    },
    {
      name: 'ok',
      path: '/ok',
      component: () => import('@/pages/main/Main'),
    },
    {
      name: 'test',
      path: '/test',
      component: () => import('@/pages/test/Test'),
    },
  ],
});

// router.beforeEach((to, from, next) => {
//   if (!store.getters['user/isAuthenticated'] && to.path !== '/login') {
//     next('/login');
//   } else {
//     next();
//   }
// );

export default router;
