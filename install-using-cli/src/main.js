import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

// Vue 인스턴스 생성 전에 전역 컴포넌트 선언

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
