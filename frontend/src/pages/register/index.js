/* eslint-disable space-before-blocks */
/* eslint-disable spaced-comment */
/* eslint-disable no-var */
/* eslint-disable no-restricted-syntax */
/* eslint-disable space-infix-ops */
import store from '../../store';


export default {
  name: 'login',

  data() {
    return {
      texterr: '',
      login: '',
      name: '',
      surname: '',
      password: '',
    };
  },

  methods: {
    register: function () {
    },
  },
  computed: {
    stat: function () {
      const stat = store.getters.authStatus;
      return stat;
    },
  },
};
