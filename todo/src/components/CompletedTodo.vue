<template>
  <div>
    Completed Todo : {{ numberOfCompletedTodo }}
  </div>
</template>

<script>
export default {
    computed: {
      // todos() {
      //   // state를 가져올 때는 computed안에 작성하기
      //   return this.$store.state.todos;
        
      // },
      numberOfCompletedTodo() {
        //계산된 값을 가져오게 하는 역할을 한다. 
        return this.$store.getters.numberOfCompletedTodo;
      }
    }
}
</script>

<style>

</style>