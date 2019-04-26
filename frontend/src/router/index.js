import Vue from 'vue';
import Router from 'vue-router'; // eslint-disable-next-line
import store from '@/store';

Vue.use(Router);

const router = new Router({
  routes: [
    {
      path: '/',
      component: () => import('@/pages/Main'),
    },
    {
      name: 'login',
      path: '/login',
      component: () => import('@/pages/login/Login'),
    },
  ],
});

router.beforeEach((to, from, next) => {
  if (!store.getters['user/isAuthenticated'] && to.path !== '/login') {
    next('/login');
  } else {
    next();
  }
});

export default router;
