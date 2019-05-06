import store from '../../store';


export default {
  name: 'login',

  data: () => ({
    countries: [],
    items: [
      { title: 'Click Me1' },
      { title: 'Click Me2' },
      { title: 'Click Me3' },
      { title: 'Click Me4' },
    ],
  }),
  methods: {
    func: function (country) {
      const countryId = country.id;
      this.$router.push({ name: 'test', params: { id: countryId } });
    },
    addCountry: function () {
      this.$router.push({ name: 'addCountry' });
    },
    addQuestion: function () {
      this.$router.push({ name: 'addQuestion' });
    },
    editCountry: function () {
      this.$router.push({ name: 'addCountry', params: { changing: true } });
    },
    editQuestion: function () {
      this.$router.push({ name: 'editQuestion' });
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
