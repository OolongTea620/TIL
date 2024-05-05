<template>
  <div id="app" class="container">
    <h1 class="text-center">Todo App</h1>
    <!-- state를 사용하면 더 이상 props를 사용하지 않아도 괜찮음 -->
    <CompletedTodo /> 
    <AddTodo />
    <hr>
    <!-- component는 여러개 생성해서 사용 가능 하다 -->
    <TodoList />
    <!-- {{ todos }} -->
    <UserList />
  </div>
</template>

<script>
import TodoList from '@/components/TodoList.vue';
import AddTodo from '@/components/AddTodo.vue';
import CompletedTodo from '@/components/CompletedTodo.vue';
import UserList from '@/components/UserList.vue';

export default {
  components: {
    TodoList,
    AddTodo,
    CompletedTodo,
    UserList
  }
};
</script>

<style>
</style>
