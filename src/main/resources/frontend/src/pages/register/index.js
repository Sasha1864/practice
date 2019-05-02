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
      const { login, password } = this;
      this.$store.dispatch('user/AUTH_REQUEST', { login, password }).then(() => {
        this.$router.push('/ok');
      }).catch(() => {
        console.log('authorization error');
      });
    },
  },
  computed: {
    stat: function () {
      const stat = store.getters.authStatus;
      return stat;
    },
  },
};
