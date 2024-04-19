<template>
  <div>
    <h1>This is Home Page</h1>
    <form action="">
      <InputField :name="name"/>
      <br><button>Submit</button>
    </form>
    {{ name }}
  </div>  
</template>

<script>
import InputField from '@/components/inputField.vue';
export default {
  components: {
    InputField
  },
  data() {
    return {
      name: ''
    }
  }
}
</script>

<!-- scoped의 의미: 
여기 파일 컴포넌트 안에서 지역적으로 적용하겠다는 의미-->

<style scoped>
h1 {
  color: red;
}
</style>