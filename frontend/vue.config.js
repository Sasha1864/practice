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
        target: 'http://192.168.38.173:8088/',
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
