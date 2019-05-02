<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4 class="user-form">
            <v-card class="elevation-12">
              <div class="primary white--text text-xs-center">
                <div class="conf title">Имя проекта</div>
              </div>
              <v-card-text>
                <v-form class="login" @submit.prevent="loginm">
                  <v-text-field
                    name="login"
                    label="Логин"
                    type="text"
                    v-model="login"
                    autofocus
                  ></v-text-field>
                  <v-text-field
                    id="password"
                    name="password"
                    label="Пароль"
                    type="password"
                    v-model="password"
                  ></v-text-field>
                  <v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                    @click="loginm"
                  >
                    Вход</v-btn
                  >
                  <v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                    @click="register"
                  >
                    Регистрация</v-btn
                  >
                </v-form>
                <p v-if="stat == 'error'" class="err1">
                  <!-- Неверный логин или пароль -->
                </p>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>
<script src="./index.js"></script>
<style lang="scss" src="./style.scss" scoped></style>
