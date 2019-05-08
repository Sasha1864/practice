/* eslint-disable global-require */
/* eslint-disable no-unused-vars */
/* eslint-disable no-var */
/* eslint-disable space-before-blocks */
import Vue from 'vue';
import Axios from 'axios';

const localVue = new Vue();
// const baseUrl = '172.16.13.200:9082';
const baseUrl = 'localhost:8080';
const getters = {
};

const actions = {// eslint-disable-next-line
    GET_QUESTIONS: ({ commit, dispatch }, countryId) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/country/${countryId}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  GET_QUESTION_BY_ID: ({ commit, dispatch }, id) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/${id}`;
    fetch(url)
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  GET_LIST: ({ commit, dispatch }) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/`;
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
    const url = `http://${baseUrl}/questions/answers/${questionId}`;
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
    const url = `http://${baseUrl}/questions/save/${answer.userId}/${answer.id}`;
    fetch(url, { method: 'POST' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  ADD_QUESTION: ({ commit, dispatch }, question) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/questions/add?country.id=${question.questionCountry}&question=${question.question}`;
    fetch(url, { method: 'POST' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  EDIT_QUESTION: ({ commit, dispatch }, question) => new Promise((resolve, reject) => {
    console.log(question);
    const url = `http://${baseUrl}/questions/edit?country.id=${question.countryId}&id=${question.id}&question=${question.question}`;
    fetch(url, { method: 'PUT' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  ADD_ANSWER: ({ commit, dispatch }, answer) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/answers/add?question.id=${answer.questionId}&answer=${answer.answer}&status=${answer.status}`;
    fetch(url, { method: 'POST' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  EDIT_ANSWER: ({ commit, dispatch }, answer) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/answers/edit?question.id=${answer.questionId}&id=${answer.id}&answer=${answer.answer}&status=${answer.status}`;
    fetch(url, { method: 'PUT' })
      .then((resp) => {
        resolve(resp);
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  }),
  DELETE_ANSWER: ({ commit, dispatch }, id) => new Promise((resolve, reject) => {
    const url = `http://${baseUrl}/questions/answers/delete?id=${id}`;
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
