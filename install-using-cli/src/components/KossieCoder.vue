<template>
    <div>
        <p>header</p>
        <slot name="header" :kossie="kossie"></slot>
        <p>Body</p>
        <!-- default로  해당 된 부분으로 교체됨 -->
        <slot></slot>
        <p>
            footer
        </p>
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
            kossie: 'coder'
            // name : 'Kossie Coder',
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
