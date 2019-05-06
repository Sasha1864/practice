/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';
import Axios from 'axios';

const localVue = new Vue();
// const baseUrl = '192.168.38.173:8088';
const baseUrl = '172.16.13.200:9082';
const getters = {
};

const actions = {
  GET_LIST: ({ commit, dispatch }) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/countries/list`;
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
    const url = `http://${baseUrl}/countries/${countryId}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  ADD_COUNTRY: ({ commit, dispatch }, country) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/countries/add?name=${country.country}&image=${country.img}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  EDIT_COUNTRY: ({ commit, dispatch }, country) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/countries/edit?id=${country.id}&name=${country.country}&image=${country.img}`;
    fetch(url, { method: 'PUT' })
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
