<template>
  <div id="app" class="container">
    <h1 class="text-center">Todo App</h1>
    <input 
      type="text" 
      class="w-100 p-2" 
      placeholder="Type todo"
      @keyup.enter="addTodo"
    >
    <hr>
    <!-- component는 여러개 생성해서 사용 가능 하다 -->
    <Todo 
      v-for="todo in todos" 
      :key="todo.id"
      :todo="todo"
      @toggle-checkbox="toggleCheckbox"
      @click-delete="deleteTodo"
    />

    <!-- {{ todos }} -->
  </div>
</template>

<script>
import Todo from '@/components/Todo.vue';
export default {
  components: {
    Todo
  },
  data() {
    return {
      todos: [
        { id: 1, text: 'buy a car', checked: false },
        { id: 2, text: 'eat lunch', checked: true },
        { id: 3, text: 'go to sleep', checked: false },
      ]
    }
  },
  methods: {
    deleteTodo(id) {
      // const index = this.todos.findIndex(todo => {
      //   return todo.id === id;
      // })
      // this.todos.splice(index,1);
      this.todos = this.todos.filter(todo => todo.id !== id)
    },
    addTodo(e) {
      this.todos.push(
        {
          id: Math.random(), 
          text: e.target.value,
          checked: false
        }
      )
    },
    toggleCheckbox({id, checked}) {
      const index = this.todos.findIndex(todo => {
        return todo.id === id;
      })
      this.todos[index].checked = checked;
    }
  }
};
</script>

<style>
</style>
