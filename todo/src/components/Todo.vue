<template>
  <div class="mb-2 d-flex">
    <div>
        <input type="checkbox" :checked="todo.checked"
        @change="toggleCheckbox">
    </div>
        
        <span 
            class="ml-3 flex-grow-1"
            :class="todo.checked ? 'text-muted' : ''"
            :style="todo.checked ? 'text-decoration: line-through' : ''"
        >
        {{ todo.text }}
        </span>
        <button 
            class="btn btn-danger btn-sm flex-shrink-1"
            @click="clickDelete"
        > Delete </button>
    </div>
</template>

<script>
export default {
    props: {
        todo: {
            type: Object,
            required: true
        }
    },
    methods: {
        toggleCheckbox(e) {
            // id 와 checked 여부를 부모 컴포넌트로 넘겨줌
            this.$emit('toggle-checkbox', {
                id: this.todo.id,
                checked: e.target.checked
            }) 

        },
        clickDelete(e) {
            this.$emit('click-delete', this.todo.id);
        }
    }

}
</script>

<style>

</style>