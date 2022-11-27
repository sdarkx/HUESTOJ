<template>
    <NavBarSec />
    <ContentBase>
        <div>
            <textarea style="text-align: center;" v-model="markdown"></textarea>
            <div v-html="markdownToHtml"></div>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import { marked } from 'marked';
import NavBarSec from '@/components/NavBarSec.vue'

export default {
    name: "HomeView",
    components: {
        ContentBase,
        NavBarSec,
    },
    data() {
        return {
            markdown: "`Hello World`"
        };
    },
    computed: {
        markdownToHtml(){
            return marked(this.markdown);
        }
    }
};
</script>

<style scoped>
</style>
