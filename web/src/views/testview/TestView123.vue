<template>
    <ContenBase>
        <div>
            <div class="code_head" title="代码编辑器">
                <div style="width: 100%; hight: 100px;">
                    <!-- 语言选择框 -->
                    <el-select
                        v-model="submit_code.language"
                        style="width: 120px; margin-left: 10px"
                        placeholder="选择语言"
                    >
                        <el-option
                            v-for="lang in langs"
                            :key="lang.value"
                            :value="lang.lable"
                            :lable="lang.value"
                        />
                    </el-select>
                </div>
            </div>
            <div class="code_body">
                <VAceEditor
                    v-model:value="submit_code.code_demo"
                    @init="options"
                    :lang="submit_code.language"
                    theme="xcode"
                    style="height: 300px"
                />
            </div>
        </div>
    </ContenBase>
</template>


<script>
import ContenBase from "../../components/ContentBase.vue";
import ace from "ace-builds";
import { reactive } from "vue";
import { VAceEditor } from "vue3-ace-editor";
import "ace-builds/webpack-resolver";
import "ace-builds/src-noconflict/mode-json";
import "ace-builds/src-noconflict/theme-chrome";
import "ace-builds/src-noconflict/ext-language_tools";

export default {
    name: "TestView",
    components: {
        ContenBase,
        VAceEditor,
    },
    setup() {
        // 编辑器设置
        const themes = ["xcode", "eclipse", "monokai", "cobalt"];
        const langs = [
            {
                value: "1",
                lable: "C++",
            },
            {
                value: "2",
                lable: "C",
            },
            {
                value: "3",
                lable: "Java",
            },
            {
                value: "4",
                lable: "Python",
            },
        ];
        const tables = [2, 4, 8];
        const fontSizes = [14, 15, 16, 17, 18, 19, 20, 21, 22];
        const options = {
            tabSize: 4, // tab默认大小
            showPrintMargin: false, // 去除编辑器里的竖线
            fontSize: 20, // 字体大小
            highlightActiveLine: true, // 高亮配置
            enableBasicAutocompletion: true, //启用基本自动完成
            enableSnippets: true, // 启用代码段
            enableLiveAutocompletion: true, // 启用实时自动完成
        };
        ace.config.set(
            "basePath",
            "https://cdn.jsdelivr.net/npm/ace-builds@" +
                require("ace-builds").version +
                "/src-noconflict/"
        );
        const editorInit = {};

        //
        const submit_code = reactive({
            language: "",
            code_demo: "",
            default: {
                language: "1",
            },
        });

        return {
            themes,
            langs,
            tables,
            fontSizes,
            options,
            editorInit,
            submit_code,
        };
    },
};
</script>


<style scoped>
</style>