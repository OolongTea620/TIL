<template>
    <div>
        <label for="">Name</label>
        <input 
            type="text" 
            :value="value" 
            style="padding: 30px; border: 2px solid green;"
            @input="$emit('input', $event.target.value)" 
        >
    </div>
</template>

<script>
export default {
    props: {
        // name: {
        //     type: String,
        //     required: true
        // }
        value: {
            type: String,
            required: true
        }
        
    },
    // methods: {
    //     updatedName(e) {
    //         // input 이벤트가 일어날 때 마다 값이 출력됨
    //         console.log(e.target.value);
    //         this.$emit('update-name', e.target.value);
    //     }
    // }
}
</script>
