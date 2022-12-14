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
                        <el-main style="padding: 0">
                            <div v-html="markdownToHtml"></div>
                        </el-main>
                        <el-aside width="20%">
                            <div>Problem Rating : {{ pb_rating }}</div>
                            <hr>
                            <div>Accetped : {{ pb_accepted }}</div>
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
import { marked } from "marked";

export default {
    name: "ProblemDescript",
    components: {
        ContentBase,
    },
    setup() {
        let pb_id = ref();
        let pb_describe = ref("");
        let pb_rating = ref("");
        let pb_accepted = ref("");

        const getproblemdescript = () => {
            $.ajax({
                url: "http://localhost:8091/problem/getdesc/",
                type: "get",
                data: {
                    pb_id: pb_id.value,
                },
                success(resp) {
                    pb_describe.value = resp.pb_describe;
                    pb_rating.value = resp.pb_rating;
                    pb_accepted.value = resp.pb_accepted;
                    console.log(resp);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        return {
            pb_id,
            pb_describe,
            pb_rating,
            pb_accepted,
            getproblemdescript,
        };
    },
    mounted() {
        this.pb_id = this.$route.query.pb_id;
        this.getproblemdescript();
    },
    computed: {
        markdownToHtml() {
            return marked(this.pb_describe);
        },
    },
};
</script>


<style scoped>
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

