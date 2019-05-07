module.exports = {
  outputDir: '../main/resources/frontend/',
  indexPath: 'index.html',
  baseUrl: '/',
  devServer: {
    watchOptions: {
      poll: 1000,
    },
    proxy: {
      '^/api': {
        target: 'http://192.0.0.1/',
        ws: true,
        proxyTimeout: 5000,
      },
    },
    overlay: {
      warnings: true,
      errors: true,
    },
  },
};
