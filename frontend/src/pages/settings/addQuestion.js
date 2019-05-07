// import store from '../../store';

export default {
  data: () => ({
    errorMessages: '',
    question: null,
    answer: '',
    answers: [],
    trueAnswer: '',
    savedCountries: [],
    questionCountry: null,
    formHasErrors: false,
  }),

  computed: {
  },

  watch: {
  },

  methods: {
    addAnswer() {
      this.answers.push(this.answer);
      this.answer = '';
    },
    back() {
      this.$router.push('/ok');
    },
    addQuestion() {
      const self = this;
      const { questionCountry, question } = this;
      this.$store.dispatch('question/ADD_QUESTION', { questionCountry, question }).then(
        (result) => {
          result.json().then(function (questionId) {
            self.answers.forEach((answer) => {
              let status = '';
              if (answer === self.trueAnswer) {
                status = true;
              } else status = false;
              self.$store.dispatch('question/ADD_ANSWER', { questionId, answer, status });
            });
          });
        },
      );
    },
  },
  mounted() {
    const self = this;
    if (self.$route.params.changing) {
      self.countries = [];
      self.buttonText = 'Изменить';
    }
    this.$store.dispatch('country/GET_LIST').then(
      (result) => {
        result.json().then(function (data) {
          data.forEach((element) => {
            self.savedCountries.push(element);
          });
        });
      },
    );
  },
};
