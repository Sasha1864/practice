<template>
<div id="app">
  <v-app id="inspire">
    <v-layout justify-center>
      <v-flex xs12 sm10 md8 lg6>
        <v-card ref="form">
          <v-card-text>
            <v-autocomplete
              ref="country"
              v-model="country"
              :rules="[() => !!country || 'Это поле пустое']"
              :items="countries"
              label="Страна"
              placeholder="Выберите страну..."
              required
            ></v-autocomplete>
            <v-text-field
              ref="url "
              v-model="img"
              :rules="[() => !!name || 'Это поле пустое']"
              :error-messages="errorMessages"
              label="url картинки"
               placeholder="http://"
              required
            ></v-text-field>
          </v-card-text>
          <v-divider class="mt-5"></v-divider>
          <v-card-actions>
            <v-btn flat>Отмена</v-btn>
            <v-spacer></v-spacer>
            <v-slide-x-reverse-transition>
              <v-tooltip
                v-if="formHasErrors"
                left
              >
                <template v-slot:activator="{ on }">
                  <v-btn
                    icon
                    class="my-0"
                    @click="resetForm"
                    v-on="on"
                  >
                    <v-icon>refresh</v-icon>
                  </v-btn>
                </template>
                <span>Refresh form</span>
              </v-tooltip>
            </v-slide-x-reverse-transition>
            <v-btn color="primary" flat @click="submit">Добавить</v-btn>
          </v-card-actions>
        </v-card>
        <v-card class="card" ref="form">
             <v-card-text>
            <v-text-field
              ref="question"
              v-model="question"
              :rules="[() => !!name || 'Это поле пустое']"
              :error-messages="errorMessages"
              label="Вопрос"
               placeholder="Введите вопрос..."
              required
            ></v-text-field>
            <v-text-field
              ref="url "
              v-model="answer"
              label="Ответ"
               placeholder="Введите ответ на вопрос..."
              required
            ></v-text-field>
            <v-btn
                    icon
                    class="my-0"
                    @click="addAnswer"
                    v-on="on"
                  >
                    <v-icon>add</v-icon>
                  </v-btn>
 <v-radio-group v-model="trueAnswer">
                <v-radio
                  v-for = "answer in answers"
                  v-bind:value = "answer"
                  :key="answer"
                  :label="`${answer}`"
                ></v-radio>
              </v-radio-group>
             </v-card-text>
             <v-divider class="mt-5"></v-divider>
            <v-card-actions>
            <v-btn flat>Отмена</v-btn>
            <v-spacer></v-spacer>
            <v-slide-x-reverse-transition>
              <v-tooltip
                v-if="formHasErrors"
                left
              >
                <template v-slot:activator="{ on }">
                  <v-btn
                    icon
                    class="my-0"
                    @click="resetForm"
                    v-on="on"
                  >
                    <v-icon>refresh</v-icon>
                  </v-btn>
                </template>
                <span>Refresh form</span>
              </v-tooltip>
            </v-slide-x-reverse-transition>
            <v-btn color="primary" flat @click="submit">Добавить</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-app>
</div>
</template>
<script src="./setting.js"></script>
<style scoped>
.card{
    margin-top: 20px;
}
</style>
