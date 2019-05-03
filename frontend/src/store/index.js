import Vue from 'vue';
import Vuex from 'vuex';

import user from '@/store/modules/user';
import question from '@/store/modules/question';

Vue.use(Vuex);


export default new Vuex.Store({
  modules: {
    user,
    question,
  },
});
