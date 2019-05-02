import store from '../../store';

export default {
  name: 'login',

  data() {
    return {
      texterr: '',
      login: '',
      password: '',
    };
  },

  methods: {
    loginm: function () {
      const { login, password } = this;
      this.$store.dispatch('user/AUTH_REQUEST', { login, password }).then(() => {
        this.$router.push('/');
      }).catch((error) => {
        this.texterr = error.response.data.message;
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
