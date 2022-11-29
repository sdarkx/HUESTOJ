<template>
    <div>
        <div>
            <monaco-editor style="width:800px; height:500px;margin-left:15%;" />
        </div>
    </div>
    <!-- vue2每个template内有一个div标签 -->
</template>

<script>
import monacoEditor  from './components/CodeEditer.vue'

export default {
    name: "OJmonaco",
    data: function () {
        return {};
    },
    components: {
        monacoEditor,
    },
};
</script>

<style scoped>
</style>
