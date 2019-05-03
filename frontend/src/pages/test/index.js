
export default {
  data() {
    return {
      question: { name: '', id: 0 },
      country: { id: 1, name: 'name', img: '' },
      answers: ['1', '2', '3', '4'],
    };
  },

  methods: {
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
          console.log(data);
        });
      },
    );
    console.log(self.question.id, self.country.id);
    this.$store.dispatch('question/GET_ANSWERS', 1, self.country.id).then(
      (result) => {
        result.json().then(function (data) {
          /* self.question.name = data.question;
          self.question.id = data.id;
          self.country.name = data.country.name;
          self.country.img = data.country.image; */
          console.log(data);
        });
      },
    );
  },
};
