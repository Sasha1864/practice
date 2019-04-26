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
    localVue.$Axios.post('/api/login', user)
      .then((resp) => {
        // eslint-disable-next-line
        const token = resp.data.token;
        localStorage.setItem('user-token', token);
        commit('SET_TOKEN', token);

        const auth = `Bearer ${token}`;
        localVue.$Axios.defaults.headers.common.Authorization = auth;

        resolve(resp);
      })
      .catch((err) => {
        localStorage.removeItem('user-token');
        reject(err);
      });
  }),

  AUTH_LOGOUT: ({ commit }) => new Promise((resolve) => {
    localStorage.removeItem('user-token');
    commit('SET_TOKEN', '');
    delete localVue.$Axios.defaults.headers.common.Authorization;

    resolve();
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
