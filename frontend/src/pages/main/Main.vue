<template>
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
            v-for="(item, index) in items"
            :key="index"
            @click="func"
          >
            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu>
</template>

<script src="./index.js"></script>
