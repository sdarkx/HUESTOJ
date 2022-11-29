<template>
    <ContentBase>
        <CodeEditer style=""></CodeEditer>
    </ContentBase>
</template>

<script>
import ContentBase from "@/components/ContentBase.vue";
import CodeEditer from '../../components/CodeEditer.vue'

export default {
    name: "TestView",
    components: {
        ContentBase,
        CodeEditer,
    },
};
</script>

<style scoped>
</style>
