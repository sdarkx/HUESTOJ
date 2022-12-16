<template>
    <NavBarSec />
    <ContentBase>
        <div>
            <div>
                <!-- <textarea
                    style="text-align: center"
                    v-model="markdown"
                ></textarea>
                <div v-html="markdownToHtml"></div> -->
                <!-- ----------------分割线---------------- -->
                <div>
                    <h4 style="text-align: center">{{ nt_title }}</h4>
                    <!-- 标题 -->
                    <div
                        style="
                            font-size: 12px;
                            padding-top: 25px;
                            padding-bottom: 40px;
                        "
                    >
                        <p style="display: inline; padding-left: 25%">
                            {{ nt_time }}
                        </p>
                        <p style="display: inline; padding-left: 25%">
                            点击次数【{{ nt_count }}】
                        </p>
                    </div>
                    <!-- 正文 -->
                    <div style="font-size: 20px; height: 580px;">
                        <p v-html="markdownToHtml"></p>
                    </div>
                    <!-- 最后一行 上下页 -->
                    <div>
                        <div class="btn_begin_mid_end">
                            <el-button
                                text
                                @click="handleCurrentChange(-1)"
                                :disabled="current === 1 ? true : false"
                                >上一页</el-button
                            >
                            <div style="font-size: 12px">
                                最后修改于 {{ nt_up_time }}
                            </div>
                            <!-- next -->
                            <el-button
                                text
                                :disabled="current === total ? true : false"
                                @click="handleCurrentChange(1)"
                                >下一页</el-button
                            >
                        </div>
                    </div>
                </div>
            </div>
            <!-- 测试链接 -->
            <div>
                <router-link :to="{ name: 'TestView' }" style=""
                    >ojcoder</router-link
                >
            </div>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import { marked } from "marked";
import NavBarSec from "@/components/NavBarSec.vue";
import { ref } from "vue";
import $ from "jquery";

export default {
    name: "HomeView",
    components: {
        ContentBase,
        NavBarSec,
    },
    setup() {
        let markdown = ref("`whe`");
        let current = ref(2);
        let error_message = ref("");
        let nt_title = ref("");
        let nt_time = ref("");
        let nt_up_time = ref("");
        let total = ref();
        let nt_author = ref("");
        let nt_count = ref();
        let nt_text = ref("");

        const getnotice = () => {
            $.ajax({
                url: "http://localhost:8091/home/notice/",
                type: "get",
                data: {
                    current_page: current.value,
                },
                success(resp) {
                    nt_title.value = resp.nt_title;
                    nt_time.value = resp.nt_time;
                    nt_up_time.value = resp.nt_up_time;
                    nt_count.value = parseInt(resp.nt_count);
                    nt_text.value = resp.nt_text;
                    nt_author.value = resp.nt_author;
                    total.value = parseInt(resp.total);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        const handleCurrentChange = (val) => {
            current.value += parseInt(val);
            getnotice();
        };

        return {
            markdown,
            current,
            error_message,
            nt_title,
            nt_time,
            nt_up_time,
            total,
            nt_author,
            nt_count,
            nt_text,
            getnotice,
            handleCurrentChange,
        };
    },
    mounted() {
        this.getnotice();
    },
    computed: {
        markdownToHtml() {
            return marked(this.nt_text);
        },
    },
};
</script>

<style scoped>
.btn_begin_mid_end {
    display: flex;
    justify-content: space-between;
    padding-top: 20px;
}
</style>
