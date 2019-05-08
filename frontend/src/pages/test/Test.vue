<template>
  <v-app id="inspire">
    <v-container fluid>
       <div class = "button1">
            <h1 class='country'>{{country.name}}</h1>
            <img :src="`${country.image}`">
        </div>
        <div v-for = "question in questions" :key="question.question">
              <h1> {{question.question}}</h1>
              <v-radio-group v-model="selectedAnswers[questions.indexOf(question)]">
                <v-radio
                  v-for = "answer in question.answers"
                  v-bind:value = "answer"
                  :key="answer.answer"
                  :label="`${answer.answer}`"
                ></v-radio>
              </v-radio-group>
      </div>
      <h2>Количество правильных ответов: {{numberOfTrueAnswers}}</h2>
      <div class = "buttons"></div><v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                    @click="saveAnswer"
                  >
                    OK</v-btn
                  >
                   <v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                    @click="saveAnswer"
                  >
                    Назад</v-btn
                  >
    </v-container>
  </v-app>
</template>
<script src="./index.js"></script>
<style scoped>
img{
    display: inline-block;
    width: 50px;
    margin-left: 20px;
}
.country{
     display: inline-block;
}
.button1{
    margin-left: 50%;
}
.buttons{
  display:inline-flex;
}
</style>
