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
    trueAnswer: function () {
      /* console.log(trueAnswer);
      const questionId = this.selectedQuestion;
      const { answer, id } = trueAnswer;
      const status = true;
      this.$store.dispatch('question/EDIT_ANSWER', {
        questionId: questionId, answer, id, status,
      }); */
    },
  },

  methods: {
    addAnswer() {
      const self = this;
      const status = false;
      const questionId = this.selectedQuestion;
      const { answer } = this;
      this.$store.dispatch('question/ADD_ANSWER', { questionId: questionId, answer, status }).then(
        (result) => {
          result.json().then(function (id) {
            self.$store.dispatch('question/GET_QUESTION_BY_ID', self.selectedQuestion).then(
              (response) => {
                response.json().then(function (question) {
                  self.answers.push({ answer: self.answer, id: id, question: question });
                });
              },
            );
          });
        },
      );
      console.log(this.answers);
      // this.answer = '';
    },
    editQuestion() {
      const self = this;
      const { selectedQuestion } = this;
      this.$store.dispatch('question/GET_QUESTION_BY_ID', selectedQuestion).then(
        (result) => {
          result.json().then(function (data) {
            const { question } = self;
            const countryId = self.questionCountry.id;
            const { id } = data;
            self.$store.dispatch('question/EDIT_QUESTION', { countryId, question, id });
          });
        },
      );
      let status = false;
      this.$store.dispatch('question/GET_ANSWERS', selectedQuestion).then(
        (result) => {
          result.json().then(function (answers) {
            answers.forEach((answer) => {
              if (answer.id === self.trueAnswer.id) { status = true; } else status = false;
              self.$store.dispatch('question/EDIT_ANSWER', {
                questionId: selectedQuestion, id: answer.id, answer: answer.answer, status: status,
              });
              console.log(answer, self.trueAnswer);
            });
          });
        },
      );
      this.$router.push('/ok');
    },
    back() {
      this.$router.push('/ok');
    },
    deleteAnswer(answer) {
      this.answers.splice(this.answers.indexOf(answer), 1);
      this.$store.dispatch('question/DELETE_ANSWER', answer.id);
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
