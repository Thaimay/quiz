import { resolve } from "url";

const api = {
  addTodo(todo) {
    console.log("API: Calling service");
    console.log(todo);
    return new Promise(resolve => {
      setTimeout(() => {
        console.log("API: Service call done");
        resolve(true);
      }, 1000);
    });
  }
};

export default api;
