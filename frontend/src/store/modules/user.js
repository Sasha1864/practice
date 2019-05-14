/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';

const localVue = new Vue();
const baseUrl = '172.16.13.200:9082';
// const baseUrl = 'localhost:8080';

const state = {
  token: localStorage.getItem('user-token') || '',
  isAuthenticated: false,
};

const getters = {
  current: localState => !!localState.current,
  isAuthenticated: localState => localState.isAuthenticated,
};

const actions = {// eslint-disable-next-line
  GET_USERS: ({ commit, dispatch }) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/admin/users/list`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  AUTH_REQUEST: ({ commit, dispatch }, user) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/admin/users/list`;
    fetch(url)
      .then((resp) => {
        resp.json().then(function (users) {
          users.forEach(function (element) {
            if (element.login === user.login && element.password === user.password) {
              state.isAuthenticated = true;
              // console.log(state.isAuthenticated);
              resolve();
            }
          });
        });
      });
  }),
  AUTH_LOGOUT: ({ commit }) => new Promise((resolve) => {
    state.isAuthenticated = false;
    resolve();
  }),
  ADD_USER: ({ commit, dispatch }, user) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/admin/users/add?name=${user.name}&surname=${user.surname}&login=${user.login}&password=${user.password}`;
    fetch(url, { method: 'POST' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
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
