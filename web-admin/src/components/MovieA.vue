<template>
    <div>
        <h3>{{title}}</h3>
        <span>{{rating}}</span>
    </div>
</template>

<script>
export default{
    name:"MovieA",
    props:["title", "rating"],
    data: function(){
        return {

        }
    }
}
</script>
