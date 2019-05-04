export default {
  data() {
    return {
      questions: [],
      country: { id: 1, name: 'name', img: '' },
      answers: [],
      selectedAnswer: '',
      countryId: this.$route.params.id,
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
    this.$store.dispatch('country/GET_COUNTRY', this.countryId).then(
      (result) => {
        result.json().then(function (data) {
          self.country.id = data.id;
          self.country.name = data.name;
          self.country.img = data.image;
        });
      },
    );
    this.$store.dispatch('question/GET_QUESTION', this.countryId).then(
      (result) => {
        result.json().then(function (data) {
          data.forEach((element) => {
            const { id, question } = element;
            self.questions.push({ name: question, id: id });
            const { countryId } = self;
            console.log(countryId, id);
            self.$store.dispatch('question/GET_ANSWERS', { countryId, id }).then(
              (response) => {
                response.json().then(function (answers) {
                  answers.forEach((answer) => {
                    // const { id, question } = element
                    console.log(element);
                    self.answers.push(answer);
                  });
                  console.log(answers);
                });
              },
            );
          });
        });
      },
    ).then(() => {
      // const countryId = self.country.id;
      // const questionId = self.question.id;
      // this.$store.dispatch('question/GET_ANSWERS', { countryId, questionId }).then(
      //   (result) => {
      //     result.json().then(function (answers) {
      //       answers.forEach((element) => {
      //         self.answers.push(element);
      //       });
      //     });
      //   },
      // );
    });
  },
};
