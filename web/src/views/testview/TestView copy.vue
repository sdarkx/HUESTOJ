<template>
    <ContentBase>
        <div>
            <VAceEditor
                v-model:value="code_submit.code"
                @init="editorInit"
                :options="editoptions"
                :lang="cpp"
                theme="dracula"
                style="height: 400px; font-size:17px;"
            />
        </div>
    </ContentBase>
</template>


<script>
import { reactive } from "vue";
import ContentBase from "@/components/ContentBase.vue";

// code-editor
import { VAceEditor } from "vue3-ace-editor";
import ace from "ace-builds";

export default {
    name: "TestView",
    components: {
        ContentBase,
        VAceEditor,
    },
    setup() {
        ace.config.set(
            "basePath",
            "https://cdn.jsdelivr.net/npm/ace-builds@" +
                require("ace-builds").version +
                "/src-noconflict/"
        );

        const code_submit = reactive({
            langunage: "",
            code: "#include <iostream>\n\nusing namesapce std;\n\nint main(){\n\tint a, b; cin >> a >> b;\n\tcout << a + b << '\\n';\n\treturn 0;\n}",
        });

        function editorInit() {
            require("ace-builds/src-noconflict/ext-language_tools");
            require("ace-builds/src-noconflict/snippets/sql");
            require("ace-builds/src-noconflict/mode-sql");
            require("ace-builds/src-noconflict/theme-monokai");
            require("ace-builds/src-noconflict/mode-html");
            require("ace-builds/src-noconflict/mode-html_elixir");
            require("ace-builds/src-noconflict/mode-html_ruby");
            require("ace-builds/src-noconflict/mode-javascript");
            require("ace-builds/src-noconflict/mode-python");
            require("ace-builds/src-noconflict/snippets/less");
            require("ace-builds/src-noconflict/theme-chrome");
            require("ace-builds/src-noconflict/ext-static_highlight");
            require("ace-builds/src-noconflict/ext-beautify");
        }

        function editoptions() {
            
        }

        return {
            code_submit,
            editorInit,
            editoptions,
        };
    },
};
</script>

<style scoped>
</style>
