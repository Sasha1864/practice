// import store from '../../store';

export default {
  data: () => ({
    questions: [],
    selectedQuestion: null,
    answers: [],
    trueAnswer: null,
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
    },
  },

  methods: {
    editQuestion() {
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
  },
};
