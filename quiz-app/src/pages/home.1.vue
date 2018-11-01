<template>
  <f7-page>
    <f7-navbar>
      <f7-nav-left>
        <f7-link icon-if-ios="f7:menu" icon-if-md="material:menu" panel-open="left"></f7-link>
      </f7-nav-left>
      <f7-nav-title>My App</f7-nav-title>
      <f7-nav-right>
        <f7-link icon-if-ios="f7:menu" icon-if-md="material:menu" panel-open="right"></f7-link>
      </f7-nav-right>
    </f7-navbar>
    <f7-toolbar>
      <f7-link>Left Link</f7-link>
      <f7-link>Right Link</f7-link>
    </f7-toolbar>
    <f7-block strong>
      <h1 class="red">{{msg}}</h1>
      <f7-list class="new-todo-input">
        <f7-list-item>
          <f7-input :value="newTodoTitle" @input="newTodoTitle = $event.target.value" type="text" placeholder="Add new todo" v-validate="'required|email'" name="inputTodo" />
        </f7-list-item>
      </f7-list>
      <f7-button v-on:click="addTodo">Add todo</f7-button>
    </f7-block>
    <f7-block-title>Today's todos</f7-block-title>
      <f7-list>
        <f7-list-item v-for="todo in todos" :key="todo.id" :title="todo.title"></f7-list-item>
      </f7-list>
    <f7-block-title>Navigation</f7-block-title>
    <f7-list>
      <f7-list-item link="/about/" title="About"></f7-list-item>
      <f7-list-item link="/form/" title="Form"></f7-list-item>
      <f7-list-item link="/frame-manage/" title="Manage User"></f7-list-item>
    </f7-list>
    <f7-block-title>Modals</f7-block-title>
    <f7-block strong>
      <f7-row>
        <f7-col width="50">
          <f7-button fill raised popup-open="#popup">Popup</f7-button>
        </f7-col>
        <f7-col width="50">
          <f7-button fill raised login-screen-open="#login-screen">Login Screen</f7-button>
        </f7-col>
      </f7-row>
    </f7-block>
    <f7-block-title>Panels</f7-block-title>
    <f7-block strong>
      <f7-row>
        <f7-col width="50">
          <f7-button fill raised panel-open="left">Left Panel</f7-button>
        </f7-col>
        <f7-col width="50">
          <f7-button fill raised panel-open="right">Right Panel</f7-button>
        </f7-col>
      </f7-row>
    </f7-block>
    <f7-list>
      <f7-list-item link="/dynamic-route/blog/45/post/125/?foo=bar#about" title="Dynamic Route"></f7-list-item>
      <f7-list-item link="/load-something-that-doesnt-exist/" title="Default Route (404)"></f7-list-item>
    </f7-list>
  </f7-page>
</template>
<script>
import store from "../store";

export default {
  data() {
    return {
      msg: "Hello ban hien!",
      newTodoTitle: "",
      todos: store.getters.getTodos
    };
  },

  methods: {
    async addTodo(e) {
      if (
        (e && e.type === "keypress" && e.keyCode === 13) ||
        e.type === "click"
      ) {
        const self = this;
        self.$validator.validate().then(result => {
          console.log(result);
          if (!result) {
            // do stuff if not valid.
            return;
          }
        });

        self.$f7.dialog.preloader("Cho doi la hanh phuc...");
        await store.dispatch("addTodo", {
          id: 0,
          title: self.newTodoTitle
        });
        self.$f7.dialog.close();
      }
    }
  }
};
</script>
