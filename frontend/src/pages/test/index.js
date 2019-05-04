export default {
  data() {
    return {
      question: { name: '', id: 0 },
      country: { id: 1, name: 'name', img: '' },
      answers: [],
      selectedAnswer: '',
    };
  },
  methods: {
    saveAnswer: function () {
      const userId = 1;
      const { id } = this.selectedAnswer;
      console.log(id);
      this.$store.dispatch('question/SAVE_ANSWER', { userId, id });
    },
  },

  mounted() {
    const self = this;
    this.$store.dispatch('question/GET_QUESTION', this.country.id).then(
      (result) => {
        result.json().then(function (data) {
          self.question.name = data.question;
          self.question.id = data.id;
          self.country.name = data.country.name;
          self.country.img = data.country.image;
          self.country.id = data.country.id;
        });
      },
    ).then(() => {
      const countryId = self.country.id;
      const questionId = self.question.id;
      this.$store.dispatch('question/GET_ANSWERS', { countryId, questionId }).then(
        (result) => {
          result.json().then(function (answers) {
            answers.forEach((element) => {
              self.answers.push(element);
            });
          });
        },
      );
    });
  },
};
