<template>
    <div>
        UserList
        <div v-for="user in users" :key="user.id">
            {{ user.name }}
        </div>
    </div>  
</template>

<script>
import {mapState, mapActions} from 'vuex';
export default {
    created() {
        this.getUsers();
    },
    computed: {
        // todos() {
        //     return this.$store.state.todos;
        // },
        // users() {
        //     return this.$store.state.users;
        // }
        // ...mapState([
        //     'todos',
        //     'users'
        // ])
        // 'people'로 alias 주기
        ...mapState({
            users: state => state.users
        })
    },
    methods: {
        // getUsers() {
        //     this.$store.dispatch('getUsers');
        // }
        ...mapActions('user',['getUsers'])
    }
}
</script>

<style>

</style>