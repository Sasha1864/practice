import store from '../../store';


export default {
  name: 'login',

  data: () => ({
    countries: [],
  }),
  methods: {
    func: function (country) {
      const countryId = country.id;
      this.$router.push({ name: 'test', params: { id: countryId } });
    },
  },
  mounted() {
    const self = this;
    this.$store.dispatch('country/GET_LIST').then(
      (result) => {
        result.json().then(function (data) {
          data.forEach((element) => {
            self.countries.push(element);
          });
        });
      },
    );
  },
  computed: {
    stat: function () {
      const stat = store.getters.authStatus;
      return stat;
    },
  },
};
