export default {
  data() {
    return {
      questions: [],
      country: { id: 1, image: '', name: 'name' },
      selectedAnswers: [],
      countryId: this.$route.params.id,
      numberOfTrueAnswers: '',
    };
  },
  methods: {
    saveAnswer: function () {
      const self = this;
      const userId = 1;
      this.selectedAnswers.forEach((element) => {
        const { id } = element;
        self.$store.dispatch('question/SAVE_ANSWER', { userId, id });
      });
      this.numberOfTrueAnswers = this.selectedAnswers.filter(value => value.status === true).length;
    },
    back() {
      this.$router.push('/ok');
    },
  },
  mounted() {
    const self = this;
    this.$store.dispatch('country/GET_COUNTRY', this.countryId).then(
      (result) => {
        result.json().then(function (data) { self.country = data; });
      },
    );
    this.$store.dispatch('question/GET_QUESTIONS', this.countryId).then((result) => {
      result.json().then(function (data) {
        data.forEach((element) => {
          const { id, question } = element;
          self.$store.dispatch('question/GET_ANSWERS', id).then(
            (response) => {
              response.json().then(function (answers) {
                self.questions.push({ id, question, answers });
              });
            },
          );
        });
      });
    });
  },
};
