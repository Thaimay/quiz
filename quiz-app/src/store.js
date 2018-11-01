import Vuex from "vuex";
import Vue from "vue";
import api from "./api";

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    todos: [
      { id: 1, title: "Buy milk" },
      { id: 2, title: "Work out" },
      { id: 3, title: "Buy cake" },
      { id: 4, title: "See around here" }
    ]
  },
  mutations: {
    addTodo(state, todo) {
      state.todos.push(todo);
      console.log("Mutation: Ok, todo has been added!");
    }
  },
  actions: {
    async addTodo({ commit }, todo) {
      console.log("Action: Trying to add todo");
      if (!todo || !todo.title) {
        console.error("Invalid todo item");
        return;
      }
      const result = await api.addTodo(todo);
      if (result === true) {
        commit("addTodo", todo);
      } else {
        console.error("Could not add todo");
      }
    }
  },
  getters: {
    getTodos(state) {
      return state.todos;
    }
  }
});

export default store;
