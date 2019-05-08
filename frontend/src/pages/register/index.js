/* eslint-disable space-before-blocks */
/* eslint-disable spaced-comment */
/* eslint-disable no-var */
/* eslint-disable no-restricted-syntax */
/* eslint-disable space-infix-ops */
import store from '../../store';


export default {
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
      const {
        name, surname, login, password,
      } = this;
      this.$store.dispatch('user/ADD_USER', {
        name, surname, login, password,
      }).then(() => {
        this.$router.push('/login');
      });
    },
    back() {
      this.$router.push('/login');
    },
  },
  computed: {
    stat: function () {
      const stat = store.getters.authStatus;
      return stat;
    },
  },
};
