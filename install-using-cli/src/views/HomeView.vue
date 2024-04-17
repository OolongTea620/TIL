<template>
  <div>
    <h1>This is Home Page</h1>
    <kossie-coder/>
  </div>  
</template>

<script>
import KossieCoder from '@/components/KossieCoder.vue';

export default {
  components: {
    KossieCoder
  },
  data() {
    return {
      name: 'Kossie Coder'
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