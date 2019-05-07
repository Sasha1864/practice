<template>
<div id="app">
  <v-app id="inspire">
    <v-layout justify-center>
      <v-flex xs12 sm10 md8 lg6>
        <v-card class="card" ref="form">
            <v-card-text>
              <v-autocomplete
               v-model = "selectedQuestion"
              :rules="[() => !!selectedQuestion || 'Это поле пустое']"
              :items="questions"
              item-text= "question"
              item-value= "id"
              label="Вопрос"
              placeholder="Выберите вопрос..."
              required
            ></v-autocomplete>
             <v-text-field
              v-model="question"
              label="Измените вопрос"
               placeholder="Введите вопрос..."
              required
            ></v-text-field>
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
            >
            </v-autocomplete>
             <p>Ответы</p>
             <div class = "buttons">
                <v-btn class = "btn" color="primary"  v-for = "answer in answers"
                    v-bind:value = "answer"
                    icon
                    :key="answer.answer" flat
                    @click="deleteAnswer(answer)">
                    <v-icon>delete</v-icon>  <!-- {{answer.answer}} -->
                </v-btn>
              </div>
            <div class = "radios">
              <v-radio-group v-model="trueAnswer">
                  <v-radio class = "radio"
                    v-for = "answer in answers"
                    v-bind:value = "answer"
                    :key="answer.answer"
                    :label="`${answer.answer}`"
                  ></v-radio>
              </v-radio-group>
            </div>
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
             </v-card-text>
             <v-divider class="mt-5"></v-divider>
            <v-card-actions>
            <v-btn color="primary" flat @click="editQuestion">Изменить</v-btn>
            <v-btn color="primary" flat @click="back">Назад</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-app>
</div>
</template>
<script src="./editQuestion.js"></script>
<style scoped>


.card{
    margin-top: 20px;
}
 .btn{
    display: block;
}
.buttons{
  width: 100px;
   height: 100px;
   margin: 0 auto;
    /* margin-left: 200px; */
}
.radios{
  width: 100px;
  height: 50%;
  margin-top: -15%;
}
 .radio{
padding-top: 3px;
padding-bottom: 3px;
}
</style>
