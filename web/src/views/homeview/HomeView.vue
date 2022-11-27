<template>
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

export default {
    name: "HomeView",
    components: {
        ContentBase,
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
