import Vue from 'vue';

// Глобальная регистрация библиотек в корневом компоненте Vue
import axios from 'axios';

const lib = {
  install: function (LocalVue) {
    Object.defineProperty(LocalVue.prototype, '$Axios', { value: axios });
  },
};

Vue.use(lib);
