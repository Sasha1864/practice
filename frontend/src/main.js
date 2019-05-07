import Vue from 'vue';
// import VueMaterialIcon from './
import 'material-design-icons-iconfont/dist/material-design-icons.css';
import App from './App.vue';
import router from './router';
import './plugins/vuetify';
import './plugins/lib';
import store from './store';


Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
