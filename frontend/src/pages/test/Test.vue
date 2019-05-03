<template>
  <v-app id="inspire">
    <v-container fluid>
       <div class = "button1"> <h1 class='country'>{{country.name}}</h1>
        <img :src="`${country.img}`"> </div>
      <h1> {{question.name}}</h1>
      <!-- <div v-for = 'answer in answers' v-bind:key='answer'>
        <v-radio :label="`${answer}`"></v-radio>
      </div> -->
       <v-radio-group>
        <v-radio
          v-for = "answer in answers"
          :key="answer"
          :label="`${answer}`"
          :value="answer"
        ></v-radio>
      </v-radio-group>
      <v-btn
                    class="button1"
                    color="primary"
                    type="submit"
                  >
                    OK</v-btn
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
</style>
