<template>
<div class="settings">
  <div>
    <v-toolbar>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-menu>
        <template #activator="{ on: menu }">
          <v-tooltip bottom>
            <template #activator="{ on: tooltip }">
              <v-btn
                dark
                v-on="{ ...tooltip, ...menu }"
              >Настройки</v-btn>
            </template>
            <span>Настройки</span>
          </v-tooltip>
        </template>
        <v-list>
          <v-list-tile @click="addCountry">
            <v-list-tile-title>Добавление страны</v-list-tile-title>
          </v-list-tile>
          <v-list-tile  @click="addQuestion">
            <v-list-tile-title>Добавление вопроса</v-list-tile-title>
          </v-list-tile>
           <v-list-tile @click="editCountry">
            <v-list-tile-title>Изменение страны</v-list-tile-title>
          </v-list-tile>
           <v-list-tile @click="editQuestion">
            <v-list-tile-title>Изменение вопросов</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu>
         <v-btn
         color = "red"
                dark
                icon
                @click = "logOut"
              ><v-icon>logout</v-icon></v-btn>
      </v-toolbar-items>
    </v-toolbar>
  <!-- <v-menu>
        <template #activator="{ on: menu }">
          <v-tooltip bottom>
            <template #activator="{ on: tooltip }">
              <v-btn
                color="primary"
                dark
                v-on="{ ...tooltip, ...menu }"
              >Список стран</v-btn>
              <v-btn
                color="primary"
                dark
              >Чат</v-btn>
            </template>
            <span>Кликни, чтобы выбрать страну</span>
          </v-tooltip>
        </template>
        <v-list>
          <v-list-tile
            v-for="country in countries"
            :key="country.name"
            @click="func(country)"
          >
            <v-list-tile-title>{{ country.name }}</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu> -->
      <v-app id="inspire">
    <v-container fluid grid-list-sm>
    <v-layout row wrap>
        <v-flex v-for="country in countries" :key="`${country}`" xs4
            @click="func(country)">
        <v-card width="90%" hover="true">
           <v-img :src="`${country.image}`" class="image"></v-img>
          <v-card-title primary-title>
            <div>
              <h3 class="headline mb-0">{{ country.name }}</h3>
              <div> {{ card_text }} </div>
            </div>
          </v-card-title>
          <v-card-actions>
            <v-btn flat color="orange">Перейти к тесту...</v-btn>
          </v-card-actions>
        </v-card>
        </v-flex>
    </v-layout>
    </v-container>
  </v-app>
  </div>
      <div>
       <!-- <v-menu>
        <template #activator="{ on: menu }">
          <v-tooltip bottom>
            <template #activator="{ on: tooltip }">
              <v-btn
                color="primary"
                dark
                v-on="{ ...tooltip, ...menu }"
              >Настройки</v-btn>
            </template>
            <span>Настройки</span>
          </v-tooltip>
        </template>
        <v-list>
          <v-list-tile @click="addCountry">
            <v-list-tile-title>Добавление страны</v-list-tile-title>
          </v-list-tile>
          <v-list-tile  @click="addQuestion">
            <v-list-tile-title>Добавление вопроса</v-list-tile-title>
          </v-list-tile>
           <v-list-tile @click="editCountry">
            <v-list-tile-title>Изменение страны</v-list-tile-title>
          </v-list-tile>
           <v-list-tile @click="editQuestion">
            <v-list-tile-title>Изменение вопросов</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu> -->
      </div>
      <!-- <v-btn
                color="primary"
                dark
                icon
                @click = "logOut"
              ><v-icon>logout</v-icon></v-btn> -->
</div>
</template>

<script src="./index.js"></script>
<style scoped>
.image{
  height: 200px;
  box-shadow: inset 2px 2px 5px rgba(122, 117, 111, 0.5), 1px 1px 5px rgb(133, 126, 126);
 }

</style>
