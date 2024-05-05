<template>
  <div>
    Completed Todo : {{ numberOfCompletedTodo }}
  </div>
</template>

<script>
export default {
    computed: {
      todos() {
        // state를 가져올 때는 computed안에 작성하기
        return this.$store.state.todos;
        
      },
      numberOfCompletedTodo() {
          return this.todos.filter(todo => todo.checked).length;
      }
    }
}
</script>

<style>

</style>