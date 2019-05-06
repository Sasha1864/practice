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
              :rules="[() => !!img || 'Это поле пустое']"
              :error-messages="errorMessages"
              label="url картинки"
               placeholder="http://"
              required
            ></v-text-field>
          </v-card-text>
          <v-divider class="mt-5"></v-divider>
          <v-card-actions>
            <v-btn color="primary" flat @click="addCountry">{{buttonText}}</v-btn>
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
