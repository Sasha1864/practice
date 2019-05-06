// import store from '../../store';

export default {
  data: () => ({
    // eslint-disable-next-line max-len
    countries: ['Afghanistan', 'Albania', 'Algeria', 'Andorra', 'Angola', 'Anguilla', 'Antigua &amp; Barbuda', 'Argentina', 'Armenia', 'Aruba', 'Australia', 'Austria', 'Azerbaijan', 'Bahamas', 'Bahrain', 'Bangladesh', 'Barbados', 'Belarus', 'Belgium', 'Belize', 'Benin', 'Bermuda', 'Bhutan', 'Bolivia', 'Bosnia &amp; Herzegovina', 'Botswana', 'Brazil', 'British Virgin Islands', 'Brunei', 'Bulgaria', 'Burkina Faso', 'Burundi', 'Cambodia', 'Cameroon', 'Cape Verde', 'Cayman Islands', 'Chad', 'Chile', 'China', 'Colombia', 'Congo', 'Cook Islands', 'Costa Rica', 'Cote D Ivoire', 'Croatia', 'Cruise Ship', 'Cuba', 'Cyprus', 'Czech Republic', 'Denmark', 'Djibouti', 'Dominica', 'Dominican Republic', 'Ecuador', 'Egypt', 'El Salvador', 'Equatorial Guinea', 'Estonia', 'Ethiopia', 'Falkland Islands', 'Faroe Islands', 'Fiji', 'Finland', 'France', 'French Polynesia', 'French West Indies', 'Gabon', 'Gambia', 'Georgia', 'Germany', 'Ghana', 'Gibraltar', 'Greece', 'Greenland', 'Grenada', 'Guam', 'Guatemala', 'Guernsey', 'Guinea', 'Guinea Bissau', 'Guyana', 'Haiti', 'Honduras', 'Hong Kong', 'Hungary', 'Iceland', 'India', 'Indonesia', 'Iran', 'Iraq', 'Ireland', 'Isle of Man', 'Israel', 'Italy', 'Jamaica', 'Japan', 'Jersey', 'Jordan', 'Kazakhstan', 'Kenya', 'Kuwait', 'Kyrgyz Republic', 'Laos', 'Latvia', 'Lebanon', 'Lesotho', 'Liberia', 'Libya', 'Liechtenstein', 'Lithuania', 'Luxembourg', 'Macau', 'Macedonia', 'Madagascar', 'Malawi', 'Malaysia', 'Maldives', 'Mali', 'Malta', 'Mauritania', 'Mauritius', 'Mexico', 'Moldova', 'Monaco', 'Mongolia', 'Montenegro', 'Montserrat', 'Morocco', 'Mozambique', 'Namibia', 'Nepal', 'Netherlands', 'Netherlands Antilles', 'New Caledonia', 'New Zealand', 'Nicaragua', 'Niger', 'Nigeria', 'Norway', 'Oman', 'Pakistan', 'Palestine', 'Panama', 'Papua New Guinea', 'Paraguay', 'Peru', 'Philippines', 'Poland', 'Portugal', 'Puerto Rico', 'Qatar', 'Reunion', 'Romania', 'Russia', 'Rwanda', 'Saint Pierre &amp; Miquelon', 'Samoa', 'San Marino', 'Satellite', 'Saudi Arabia', 'Senegal', 'Serbia', 'Seychelles', 'Sierra Leone', 'Singapore', 'Slovakia', 'Slovenia', 'South Africa', 'South Korea', 'Spain', 'Sri Lanka', 'St Kitts &amp; Nevis', 'St Lucia', 'St Vincent', 'St. Lucia', 'Sudan', 'Suriname', 'Swaziland', 'Sweden', 'Switzerland', 'Syria', 'Taiwan', 'Tajikistan', 'Tanzania', 'Thailand', "Timor L'Este", 'Togo', 'Tonga', 'Trinidad &amp; Tobago', 'Tunisia', 'Turkey', 'Turkmenistan', 'Turks &amp; Caicos', 'Uganda', 'Ukraine', 'United Arab Emirates', 'United Kingdom', 'United States', 'Uruguay', 'Uzbekistan', 'Venezuela', 'Vietnam', 'Virgin Islands (US)', 'Yemen', 'Zambia', 'Zimbabwe'],
    errorMessages: '',
    img: null,
    question: null,
    answer: '',
    answers: [],
    trueAnswer: '',
    savedCountries: [],
    country: null,
    questionCountry: null,
    formHasErrors: false,
    buttonText: 'Добавить',
    clickFunc: 'addCountry',
  }),

  computed: {
  },

  watch: {
    name() {
      this.errorMessages = '';
    },
  },

  methods: {
    addressCheck() {
      this.errorMessages = this.address && !this.name
        ? 'Hey! I\'m required'
        : '';

      return true;
    },
    addAnswer() {
      this.answers.push(this.answer);
      this.answer = '';
    },
    addCountry() {
      const { country, img } = this;
      console.log(country, img);
      const { id } = this.savedCountries.filter(value => value.name === country).pop();
      if (!this.$route.params.changing) this.$store.dispatch('country/ADD_COUNTRY', { country, img });
      else this.$store.dispatch('country/EDIT_COUNTRY', { id: id, country: country, img: img });
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
    this.$store.dispatch('question/GET_LIST').then(
      (result) => {
        result.json().then(function (data) {
          data.forEach((element) => {
            if (self.$route.params.changing) self.countries.push(element.name);
            self.savedCountries.push(element);
          });
        });
      },
    );
  },
};
