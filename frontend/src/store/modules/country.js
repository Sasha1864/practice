/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';
import Axios from 'axios';

const localVue = new Vue();

const getters = {
};

const actions = {
  GET_LIST: ({ commit, dispatch }) => new Promise((resolve, reject) => {
    const url = 'http://localhost:8080/countries/list';
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  GET_COUNTRY: ({ commit, dispatch }, countryId) => new Promise((resolve, reject) => {
    const url = `http://localhost:8080/countries/${countryId}`;
    fetch(url)
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
};

export default {
  namespaced: true,
  getters,
  actions,
  mutations,
};
