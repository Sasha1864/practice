module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    'plugin:vue/essential',
    '@vue/airbnb',
  ],
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 2 : 0,
    'max-len': [2, 120, 4, { ignoreUrls: true }],
    'no-param-reassign': ['error', { props: false }],
    'no-underscore-dangle': 0,
    'import/no-extraneous-dependencies': 0,
    'no-case-declarations': 0,
    'no-continue': 0,
    'consistent-return': 0,
    'linebreak-style': 0,
    'no-new': 0,
    'object-shorthand': 0,
    'func-names': 0,
    'prefer-arrow-callback': 0,
    'no-undef': 0,
    'no-debugger': 0,
  },
  parserOptions: {
    parser: 'babel-eslint',
  },
};
