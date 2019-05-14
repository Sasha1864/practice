<template>
  <v-app id="inspire">
    <v-content>
      <v-container
        fluid
        fill-height
      >
        <v-layout
          align-center
          justify-center
        >
          <v-flex
            xs12
            sm8
            md4
            class="user-form"
          >
            <v-card class="elevation-12">
              <div class="primary white--text text-xs-center">
                <div class="conf">Регистрация</div>
              </div>
              <v-card-text>
                <v-form
                  class="login"
                >
                  <v-text-field
                  prepend-icon="person"
                    name="login"
                    label="Логин"
                    type="text"
                    v-model="login"
                    autofocus
                  ></v-text-field>
                  <v-text-field
                   prepend-icon="edit"
                    name="Name"
                    label="Имя"
                    type="text"
                    v-model="name"
                    autofocus
                  ></v-text-field>
                  <v-text-field
                  prepend-icon="edit"
                    name="Surname"
                    label="Фамилия"
                    type="text"
                    v-model="surname"
                    autofocus
                  ></v-text-field>
                  <v-text-field
                  prepend-icon="lock"
                    id="password"
                    name="password"
                    label="Пароль"
                    type="password"
                    v-model="password"
                  ></v-text-field>
                    <!-- <v-btn
                    class="button2"
                    color="primary"
                    type="submit"
                    @click="back"
                  > Назад<v-icon right>reply</v-icon>
                    </v-btn> -->
                    <v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                    @click="register"
                  >
                    OK</v-btn>
                     <p class="message"> <a @click="back">Вернуться к авторизации</a></p>
                </v-form>
                <p
                  v-if="stat == 'error'"
                  class="err1"
                >
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
