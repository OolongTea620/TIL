<template>
  <div>
    <h1>This is Home Page</h1>
    <form action="">
      <!-- <InputField :name="name" @update-name="name = $event.target.value"/> -->
      <InputField v-model="name" />
      <br><button @click="updateName">Submit</button>
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
      name: 'Kossie Coder'
    }
  },

  beforeCreate() {
    // 아직 name에 접근 불가능
    console.log('beforeCreate',this.name);
  },
  
  created() {
    // name 접근 가능
    console.log('created',this.name);
  },
  
  beforeMount() {
    // <div id="app">이 비어있음
      alert('beforeMount');
  },
  
  mounted() {
      // <div id="app">내부가 채워짐
      // 관련 DOM 접근이 가능해짐 
    alert('mounted');
  },
  
  beforeUpdate() {
    alert('beforeUpdate');
  },
  
  updated() {
    alert('updated');
  },
  
  /**
   * 메모리 누수를 방지하기 위해서 이벤트 리스너를 삭제
   * 대이터 초기화 작업
   */
  beforeDestroy() {
    
    alert('beforeDestroy');
  },
  destroyed() {
    alert('destroyed');
  },
  methods: {
    updateName() {
      this.name = 'hello';
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