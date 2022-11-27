<template>
    <NavBarSec/>
    <ContentBase>
        <div>
            <el-button @click="showdiv(true)">显示</el-button>
            <el-button @click="showdiv(false)">隐藏</el-button>
        </div>
        <div v-show="flag">
            status
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from '../../components/ContentBase.vue';
import NavBarSec from '@/components/NavBarSec.vue'

export default {
    name: "HomeView",
    components: {
        ContentBase,
        NavBarSec,
    },
    data() {
        return {
            flag: false,
        }
    },
    methods: {
        showdiv(visable) {
            this.flag = visable;
        }
    }
};
</script>

<style scoped>
</style>
