<template>
    <ContenBase>
        <!-- 题面描述 -->
        <div class="problem descript">null</div>
        <!-- 编辑器 -->
        <div>
            <!-- 编辑器头部 -->
            <div class="code_head">
                <nav class="navbar navbar-light bg-light">
                    <div style="width: 100%; hight: 100px">
                        <!-- 语言选择框 -->
                        <el-select
                            v-model="submit_form.language"
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
                </nav>
            </div>
            <!-- 编辑器身体 -->
            <div class="code_body">
                <CodeMirror></CodeMirror>
            </div>
        </div>
    </ContenBase>
</template>


<script>
import { reactive } from "vue";
import ContenBase from "../../components/ContentBase.vue";
import CodeMirror from '../../components/CodeMirrorView.vue'

export default {
    name: "TestView",
    components: {
        ContenBase,
        CodeMirror,
    },
    setup() {
        // 配置
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
        //
        const submit_form = reactive({
            language: "",
            code_demo: "",
            default: {
                language: "1",
            },
        });

        //

        return {
            langs,
            submit_form,
        };
    },
};
</script>


<style scoped>
</style>