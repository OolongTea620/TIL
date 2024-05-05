import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state : { // 데이터가 들어감
        todos: [
            { id: 1, text: 'buy a car', checked: false },
            { id: 2, text: 'eat lunch', checked: true },
            { id: 3, text: 'go to sleep', checked: false }
        ]
    },
    mutations : { // 데이터를 실질적으로 변경 가능함
        ADD_TODO(state, value) {
            state.todos.push(
                {
                    id: Math.random(), 
                    text: value,
                    checked: false
                }
            )
        },
        TOGGLE_TODO(state, {id, checked}) {
            const index = state.todos.findIndex(todo => {
                return todo.id === id;
            })
            state.todos[index].checked = checked;
        },
        DELETE_TODO(state, todoId) {
            const index = state.todos.findIndex(todo => {
              return todo.id === todoId;
            })
            state.todos.splice(index,1);
        }
    },
    actions: { // 비동기 작업 처리
        // 데이터베이스에 새로운 todo를 저장해 달라고 요청 가능
        // 일단은 데이터 베이스 흉내를 내서 구현하자

        addTodo({commit}, value){ // context: object, payload: data
            // 여기에 비동기 작업 들어감.
            // 일단 setTimeout 사용
            setTimeout(function() {
                commit('ADD_TODO', value);
            }, 500);
        },
        toggleTodo({commit}, payload){ // context: object, payload: data
            
            setTimeout(function() {
                commit('TOGGLE_TODO', payload);
            }, 500);
        },
        deleteTodo({commit}, todoId) {
            setTimeout(function() {
                commit('DELETE_TODO', todoId);
            }, 500);
        }
    },
    getters: { // vue computed와 비슷함

    }
});