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
    GET_QUESTIONS: ({ commit, dispatch }, countryId) => new Promise((resolve, reject) => {
    const url = `http://localhost:8080/questions/country/${countryId}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  GET_ANSWERS: ({ commit, dispatch }, questionId) => new Promise((resolve, reject) => {
    const url = `http://localhost:8080/questions/answers/${questionId}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  SAVE_ANSWER: ({ commit, dispatch }, answer) => new Promise((resolve, reject) => {
    const url = `http://localhost:8080/questions/save/${answer.userId}/${answer.id}`;
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
};

export default {
  namespaced: true,
  getters,
  actions,
  mutations,
};
