<template>
    <!-- 此页面有一个神奇的bug -->
    <div>
        <ContentBase>
            <div class="common-layout">
                <el-container>
                    <el-header>
                        <el-button
                            text
                            style="margin-left: -20px"
                            @click="$router.back(-1)"
                            >back</el-button
                        >
                        <el-button text style="margin-left: 0px"
                            >submit</el-button
                        >
                        <el-button text style="margin-left: 0px"
                            >status</el-button
                        >
                    </el-header>
                    <hr style="margin-top: -20px" />
                    <el-container>
                        <!-- 题目展示 -->
                        <el-main style="padding: 0">
                            <!-- 名称及时空限制 -->
                            <div style="text-align: center">
                                <h3
                                    v-if="pb_id !== null"
                                    style="display: inline"
                                >
                                    {{ pb_id }}:
                                </h3>
                                <h3
                                    v-if="pb_name !== null"
                                    style="display: inline"
                                >
                                    {{ pb_name }}
                                </h3>
                                <h5
                                    v-if="
                                        pb_limit_time !== null &&
                                        pb_limit_memory !== null
                                    "
                                    style="font-size: 15px; padding-top: 10px"
                                >
                                    时/空限制: {{ pb_limit_time }}ms/{{
                                        pb_limit_memory
                                    }}MB
                                </h5>
                            </div>
                            <!-- 题目描述 -->
                            <div style="padding-top: 40px">
                                <!-- 题目描述 -->
                                <div v-if="pb_describe !== null">
                                    <h5 style="font-weight: bold">题目描述</h5>
                                    <p>{{ pb_describe }}</p>
                                    <autoTextarea
                                        lineHeight="30px"
                                        v-model="pb_describe"
                                    />
                                </div>
                                <!-- 输入格式 -->
                                <div
                                    v-if="pb_in !== null && pb_in !== ''"
                                    style="padding-top: 20px"
                                >
                                    <h5 style="font-weight: bold">输入格式</h5>
                                    <p>{{ pb_in }}</p>
                                </div>
                                <!-- 输出格式 -->
                                <div
                                    v-if="pb_out !== null && pb_out !== ''"
                                    style="padding-top: 20px"
                                >
                                    <h5 style="font-weight: bold">输出格式</h5>
                                    <p>{{ pb_out }}</p>
                                </div>
                                <!-- 样例 -->
                                <div style="padding-top: 20px">
                                    <div v-if="pb_simple_in !== null">
                                        <h5 style="font-weight: bold">
                                            样例输入
                                        </h5>
                                        <p>{{ pb_simple_in }}</p>
                                    </div>
                                    <div v-if="pb_simple_out !== null">
                                        <h5 style="font-weight: bold">
                                            样例输出
                                        </h5>
                                        <p>{{ pb_simple_out }}</p>
                                    </div>
                                </div>
                            </div>
                        </el-main>
                        <!-- 侧边题目数据展示 -->
                        <el-aside width="20%">
                            <div>Problem Rating : {{ pb_rating }}</div>
                            <hr />
                            <div>Accetped : {{ pb_accepted }}</div>
                            <hr />
                            <div>Author : {{ pb_author }}</div>
                        </el-aside>
                    </el-container>
                </el-container>
            </div>
        </ContentBase>
    </div>
</template>


<script>
import { ref } from "vue";
import $ from "jquery";
import ContentBase from "../../components/ContentBase.vue";
import { autoTextarea } from "auto-textarea";

export default {
    name: "ProblemDescript",
    components: {
        ContentBase,
        autoTextarea,
    },
    setup() {
        let pb_id = ref();
        let pb_name = ref("");
        let pb_limit_time = ref("");
        let pb_limit_memory = ref("");
        let pb_describe = ref("");
        let pb_in = ref("");
        let pb_out = ref("");
        let pb_simple_in = ref("");
        let pb_simple_out = ref("");
        let pb_rating = ref("");
        let pb_accepted = ref("");
        let pb_author = ref("");
        let sty_height = ref("100px");

        const getproblemdescript = () => {
            $.ajax({
                url: "http://localhost:8091/problem/getdesc/",
                type: "get",
                data: {
                    pb_id: pb_id.value,
                },
                success(resp) {
                    pb_name.value = resp.pb_name;
                    pb_limit_time.value = resp.pb_lim_time;
                    pb_limit_memory.value = resp.pb_lim_memory;
                    pb_describe.value = resp.pb_describe;
                    pb_in.value = resp.pb_in;
                    pb_out.value = resp.pb_out;
                    pb_simple_in.value = resp.pb_simple_in;
                    pb_simple_out.value = resp.pb_simple_out;
                    pb_rating.value = resp.pb_rating;
                    pb_accepted.value = resp.pb_accepted;
                    pb_author.value = resp.pb_author;
                    console.log(resp);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        return {
            pb_id,
            pb_name,
            pb_limit_time,
            pb_limit_memory,
            pb_describe,
            pb_in,
            pb_out,
            pb_simple_in,
            pb_simple_out,
            pb_rating,
            pb_accepted,
            pb_author,

            sty_height,
            getproblemdescript,
        };
    },
    methods: {},
    mounted() {
        this.pb_id = this.$route.query.pb_id;
        this.getproblemdescript();
    },
    computed: {},
};
</script>


<style scoped>
/* #pb_data_display {
    resize: none;
    width: 100%;
    background-color: rgb(249, 247, 244);
    padding: 0;
    border: none;
    display: inline-block;
    line-height: 30px;
} */
/* let code_status_colors = {
    'Uploading': "#9d9d9d",
    'Pending': '#9d9d9d',
    'Judging': '#337ab7',
    'Running': '#337ab7',
    'Too many tasks': "#d05451",
    'Upload Failed': "#d05451",
    'Input Limit Exceeded': '#d05451',
    'Compile Error': '#d05451',
    'Wrong Answer': '#d05451',
    'Time Limit Exceeded': '#d05451',
    'Memory Limit Exceeded': '#d05451',
    'Output Limit Exceeded': '#d05451',
    'Runtime Error': '#d05451',
    'Segmentation Fault': '#d05451',
    'Presentation Error': '#d05451',
    'Internal Error': '#d05451',
    'Float Point Exception': "#d05451",
    'Non Zero Exit Code': '#d05451',
    'Accepted': '#449d44',
    'Finished': '#449d44',
};

let code_status_names = {
    'Uploading': 'Uploading',
    'Pending': 'Pending',
    'Judging': 'Judging',
    'Running': 'Running',
    'Too many tasks': 'Too many tasks',
    'Upload Failed': 'Upload Failed',
    'Input Limit Exceeded':'Input Limit Exceeded',
    'COMPILE_ERROR': "Compile Error",
    'WRONG_ANSWER': 'Wrong Answer',
    'TIME_LIMIT_EXCEEDED': 'Time Limit Exceeded',
    'MEMORY_LIMIT_EXCEEDED': 'Memory Limit Exceeded',
    'OUTPUT_LIMIT_EXCEEDED': 'Output Limit Exceeded',
    'RUNTIME_ERROR': 'Runtime Error',
    'SEGMENTATION_FAULT': "Segmentation Fault",
    'PRESENTATION_ERROR': "Presentation Error",
    'INTERNAL_ERROR': "Internal Error",
    'FLOAT_POINT_EXCEPTION': "Float Point Exception",
    'NON_ZERO_EXIT_CODE': 'Non Zero Exit Code',
    'ACCEPTED': "Accepted",
    'FINISHED': 'Finished',
}; */
</style>

