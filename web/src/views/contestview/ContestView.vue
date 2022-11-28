<template>
    <NavBarSec />
    <ContentBase>
        <div>
            <el-empty :image-size="200"></el-empty>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from '../../components/ContentBase.vue'
import NavBarSec from '@/components/NavBarSec.vue'

export default {
    name: "ContestView",
    components: {
        ContentBase,
        NavBarSec,
    },
};
</script>

<style scoped>
</style>
