<template>
    <NavBarSec />
    <ContentBase>
        <div>rating</div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import NavBarSec from '@/components/NavBarSec.vue'

export default {
    name: "HomeView",
    components: {
        ContentBase,
        NavBarSec,
    },
};
</script>

<style scoped>
</style>
