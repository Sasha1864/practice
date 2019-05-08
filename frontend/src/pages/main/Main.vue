<template>
<div class="settings">
  <div>
  <v-menu>
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
      </v-menu>
  </div>
      <div>
       <v-menu>
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
      </v-menu>
      </div>
      <v-btn
                color="primary"
                dark
                icon
                @click = "logOut"
              ><v-icon>logout</v-icon></v-btn>
</div>
</template>

<script src="./index.js"></script>
<style scoped>

.settings{
display: inline-flex;
}
</style>
