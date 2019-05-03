/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';

const localVue = new Vue();

const state = {
  token: localStorage.getItem('user-token') || '',
};

const getters = {
  current: localState => !!localState.current,
  isAuthenticated: localState => !!localState.token,
};

const actions = {// eslint-disable-next-line
  AUTH_REQUEST: ({ commit, dispatch }, user) => new Promise((resolve, reject) => {
    // eslint-disable-next-line import/no-unresolved
    const users = JSON.parse('[{"login":"admin","password":"1234"}, {"login":"user","password":"12345"}]');
    console.log(users);
    users.forEach(function (element) {
      if (element.login === user.login && element.password === user.password) {
        resolve();
      }
    });
    reject();
  }),
};

const mutations = {
  SET_TOKEN: (localState, token) => {
    localState.token = token;
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
