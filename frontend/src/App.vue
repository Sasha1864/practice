<template>
  <v-app>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  created() {
    // Подставляем токен по умолчанию
    if (localStorage.getItem('user-token')) {
      const token = `Bearer ${localStorage.getItem('user-token')}`;
      this.$Axios.defaults.headers.common.Authorization = token;
    }
    // Глобальный обработчик запросов
    const vm = this;
    this.$Axios.interceptors.response.use(function (response) {
      return response;
    }, function (err) {
      if (err.response.status === 401 || err.response.status === 403) {
        vm.$store.dispatch('user/AUTH_LOGOUT');
        vm.$router.push('/login');
      }

      return Promise.reject(err.response.data);
    });
  },
};
</script>
