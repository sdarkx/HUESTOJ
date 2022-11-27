<template>
    <NavBarSec />
    <ContentBase>
        404
    </ContentBase>
</template>

<script>
import ContentBase from '../../components/ContentBase.vue';
import NavBarSec from '@/components/NavBarSec.vue'

export default {
    name: "NotFoundView",
    components: {
        ContentBase,
        NavBarSec,
    },
};
</script>

<style scoped>
</style>
