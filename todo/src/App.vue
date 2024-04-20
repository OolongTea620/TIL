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
    />
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
        { id: 1, text: 'buy a car', chacked: false },
        { id: 2, text: 'eat lunch', chacked: true },
        { id: 3, text: 'go to sleep', chacked: false },
      ]
    }
  },
  methods: {
    addTodo(e) {
      this.todos.push(
        {
          id: Math.random(), 
          text: e.target.value,
          chacked: false
        }
      )
      console.log(this.todos)
    }
  }
};
</script>

<style>
</style>
