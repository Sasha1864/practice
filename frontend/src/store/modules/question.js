/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';
import Axios from 'axios';

const localVue = new Vue();

const getters = {
};

const actions = {// eslint-disable-next-line
    GET_QUESTION: ({ commit, dispatch }, countryId) => new Promise((resolve, reject) => {
    const url = `http://192.168.38.173:8088/questions/${countryId}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  GET_ANSWERS: ({ commit, dispatch }, questionId, countryId) => new Promise((resolve, reject) => {
    const url = 'http://192.168.38.173:8088/questions/1/1/1';
    console.log(url);
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
