<template>
<div id="app">
  <v-app id="inspire">
    <v-layout justify-center>
      <v-flex xs12 sm10 md8 lg6>
        <v-card class="card" ref="form">
             <v-card-text>
               <v-autocomplete
                ref="questionCountry"
               v-model = "questionCountry"
              :rules="[() => !!questionCountry || 'Это поле пустое']"
              :items="savedCountries"
              item-text= "name"
              item-value= "id"
              label="Страна"
              placeholder="Выберите страну..."
              required
            ></v-autocomplete>
            <v-text-field
              ref="question"
              v-model="question"
              :rules="[() => !!question || 'Это поле пустое']"
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
                  >
                    <v-icon>add</v-icon>
            </v-btn>
            <p>Выберите правильный ответ</p>
              <v-radio-group v-model="trueAnswer">
                  <v-radio
                    v-for = "answer in answers"
                    v-bind:value = "answer"
                    :key="answer"
                    :label="`${answer}`"
                  >
                  </v-radio>
              </v-radio-group>
             </v-card-text>
             <v-divider class="mt-5"></v-divider>
            <v-card-actions>
            <v-btn color="primary" flat @click="addQuestion">Добавить</v-btn>
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
