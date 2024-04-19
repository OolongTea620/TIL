<template>
    <div>
        <h1>{{ title }}</h1>
        <p> {{ name }} </p>
        <button @click="updateName">Change Name</button>
    </div>
</template>

<script>
export default {
    props: {
        title: {
            type: String, // 타입
            required: false, // 필수 여부
            default: 'default title'
        }
    }, // props...
    data() {
        return {
            name : 'Kossie Coder',
        }
    },
    methods: {
        updateName() {
            this.name = 'Kossie Coder Updated'
        }
    }
}
</script>

<style scoped>
</style>
