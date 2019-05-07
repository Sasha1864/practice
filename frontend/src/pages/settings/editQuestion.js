// import store from '../../store';

export default {
  data: () => ({
    questions: [],
    selectedQuestion: null,
    question: '',
    answers: [],
    trueAnswer: null,
    answer: '',
    savedCountries: [],
    questionCountry: null,
  }),
  computed: {
  },

  watch: {
    selectedQuestion: function (id) {
      const self = this;
      this.answers = [];
      this.$store.dispatch('question/GET_ANSWERS', id).then(
        (result) => {
          result.json().then(function (data) {
            data.forEach((answer) => {
              if (answer.status === true) self.trueAnswer = answer;
              self.answers.push(answer);
            });
          });
        },
      );
      this.$store.dispatch('question/GET_QUESTION_BY_ID', id).then(
        (result) => {
          result.json().then(function (question) {
            self.question = question.question;
            self.questionCountry = question.country;
          });
        },
      );
    },
  },

  methods: {
    addAnswer() {
      console.log(this.answer);
      this.answers.push({ answer: this.answer });
      this.answer = '';
      console.log(this.answers);
    },
    editQuestion() {
      const self = this;
      const { selectedQuestion } = this;
      this.$store.dispatch('question/GET_QUESTION_BY_ID', selectedQuestion).then(
        (result) => {
          result.json().then(function (data) {
            const { question } = self;
            const countryId = data.country.id;
            const { id } = data;
            self.$store.dispatch('question/EDIT_QUESTION', { countryId, question, id });
            self.answers.forEach((answer) => {
              console.log(answer);
            });
          });
        },
      );
      // console.log(question);
      // this.$store.dispatch('question/EDIT_QUESTION').then(
      //   (result) => {
      //       });
      //     });
      //   },
      // );
    },
    back() {
      this.$router.push('/ok');
    },
    deleteAnswer(answer) {
      this.answers.splice(this.answers.indexOf(answer), 1);
    },
  },
  mounted() {
    const self = this;
    this.$store.dispatch('question/GET_LIST').then(
      (result) => {
        result.json().then(function (data) {
          data.forEach((element) => {
            self.questions.push(element);
          });
        });
      },
    );
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
