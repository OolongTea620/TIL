<template>
  <div class="about">
    <h1>This is an about page</h1>
    <!-- 
      <slot></slot> 사이에 해당 컴포넌트가 채워진다
     -->
    <KossieCoder>
      <!-- <template v-slot:header> -->
        <!-- #[name]으로 붙여서 명명 가능 -->
      <template #header="props" >
        <!-- //<slot> </slot> 태그 대신 대체됨 -->
        <p>header1 {{ props.kossie }}</p> 
      </template>
      <template v-slot:default>
        hello11
      </template>
    </KossieCoder>
  </div>
</template>

<script>
import KossieCoder from '@/components/KossieCoder.vue';
export default {
  components: {
    KossieCoder
  },
}
</script>