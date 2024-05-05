<template>
  <div id="app" class="container">
    <h1 class="text-center">Todo App</h1>
    <CompletedTodo :todos="todos" />
    <AddTodo @add-todo="addTodo"/>
    <hr>
    <!-- component는 여러개 생성해서 사용 가능 하다 -->
    <TodoList 
      :todos="todos"
      @toggle-checkbox="toggleCheckbox"
      @click-delete="deleteTodo"
    />
    <!-- {{ todos }} -->
  </div>
</template>

<script>
import TodoList from '@/components/TodoList.vue';
import AddTodo from '@/components/AddTodo.vue';
import CompletedTodo from '@/components/CompletedTodo.vue';

export default {
  components: {
    TodoList,
    AddTodo,
    CompletedTodo
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
    addTodo(value) {
      this.todos.push(
        {
          id: Math.random(), 
          text: value,
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
