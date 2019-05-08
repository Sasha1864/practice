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
      path: '/test/:id',
      component: () => import('@/pages/test/Test'),
    },
    {
      name: 'addCountry',
      path: '/addCountry/:changing?',
      component: () => import('@/pages/settings/AddCountry'),
    },
    {
      name: 'addQuestion',
      path: '/addQuestion',
      component: () => import('@/pages/settings/AddQuestion.vue'),
    },
    {
      name: 'editQuestion',
      path: '/editQuestion',
      component: () => import('@/pages/settings/EditQuestion.vue'),
    },
  ],
});

export default router;

router.beforeEach((to, from, next) => {
  console.log(store.getters['user/isAuthenticated']);
  if (!store.getters['user/isAuthenticated'] && to.path !== '/login' && to.path !== '/register') {
    next('/login');
  } else {
    next();
  }
});
