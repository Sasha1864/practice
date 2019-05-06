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
             <p>Ответы</p>
             <div class = "btn"> <v-btn class = "btn" color="primary"  v-for = "answer in answers"
                    v-bind:value = "answer"
                    icon
                    :key="answer.answer" flat ><v-icon>delete</v-icon></v-btn></div>
            <div class = "radio">  <v-radio-group v-model="trueAnswer">
                  <v-radio
                    v-for = "answer in answers"
                    v-bind:value = "answer"
                    :key="answer.answer"
                    :label="`${answer.answer}`"
                  ></v-radio>
              </v-radio-group> </div>
             </v-card-text>
             <v-divider class="mt-5"></v-divider>
            <v-card-actions>
            <v-btn color="primary" flat @click="editQuestion">Изменить</v-btn>
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
.radio{
 margin-top: -130px;
}
</style>
