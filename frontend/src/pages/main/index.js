import store from '../../store';


export default {
  name: 'login',

  data: () => ({
    items: [
      { title: ' 1 ' },
      { title: ' 2 ' },
      { title: ' 3 ' },
      { title: ' 4 ' },
    ],
  }),
  methods: {
    func: function () {
      this.$router.push('/test');
    },
  },
  computed: {
    stat: function () {
      const stat = store.getters.authStatus;
      return stat;
    },
  },
};
