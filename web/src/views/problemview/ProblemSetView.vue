<template>
    <NavBarSec />
    <ContentBase>
        <div>
            <div>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th style="width: 10%; text-align: center">#</th>
                            <th style="width: 70%; text-align: center">Name</th>
                            <th style="width: 10%; text-align: center">
                                Rating
                            </th>
                            <th style="width: 10%; text-align: center">
                                Accept
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="pb in tableDate" :key="pb.pb_id">
                            <td style="text-align: center">{{ pb.pb_id }}</td>
                            <td style="text-align: left; font-size: 14px;">
                                <router-link
                                    :to="{
                                        name: 'ProblemDescriptView',
                                        query: { pb_id: pb.pb_id },
                                    }"
                                    >{{ pb.pb_name }}</router-link
                                >
                            </td>
                            <td style="text-align: center">
                                {{ pb.pb_rating }}
                            </td>
                            <td style="text-align: center">
                                {{ pb.pb_accepted }}
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- 分页 -->
            <div id="page">
                <!-- prev -->
                <div class="btn_begin_mid_end">
                    <el-button
                        text
                        @click="handleCurrentChange(-1)"
                        :disabled="current === 1 ? true : false"
                        >上一页</el-button
                    >
                    <!-- total -->
                    <div>第{{ current }}/{{ sizes }}页</div>
                    <!-- next -->
                    <el-button
                        text
                        :disabled="current === sizes ? true : false"
                        @click="handleCurrentChange(1)"
                        >下一页</el-button
                    >
                </div>
                <!-- 前边不加v-model有问题 还是要按官方来 -->
            </div>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import NavBarSec from "@/components/NavBarSec.vue";
import $ from "jquery";
import { ref } from "vue";
import { ElMessage } from "element-plus";

export default {
    name: "ProblemSetView",
    components: {
        ContentBase,
        NavBarSec,
    },
    setup() {
        let tableDate = ref([]); // 题目列表

        let size = ref("15"); // 每页展示条数
        let total = ref(""); // 总记录数
        let current = ref(1); // 当前页
        let sizes = ref(); // 总页数

        const get_problem_list = () => {
            $.ajax({
                url: "http://localhost:8091/problem/list/",
                type: "get",
                data: {
                    current_page: current.value,
                    page_size: size.value,
                },
                success(resp) {
                    tableDate.value = resp.problems_list;
                    size.value = resp.page_list[0].size;
                    total.value = resp.page_list[0].total;
                    current.value = parseInt(resp.page_list[0].current);
                    sizes.value = parseInt(resp.page_list[0].pages);

                    console.log(resp);
                },
                error(resp) {
                    ElMessage.error(resp);
                },
            });
        };

        get_problem_list();

        const handleCurrentChange = (val) => {
            current.value += parseInt(val);
            get_problem_list();
        };

        return {
            tableDate,
            size,
            total,
            current,
            sizes,
            handleCurrentChange,
        };
    },
};
</script>

<style scoped>
.btn_begin_mid_end {
    display: flex;
    justify-content: space-between;
}
</style>
