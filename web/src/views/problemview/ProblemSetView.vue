<template>
    <NavBarSec />
    <ContentBase>
        <!-- 改成列表 我是sb用表格 -->
        <div>
            <div>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th style="width: 10%; text-align: center">Id</th>
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
                            <td style="text-align: left; font-size: 14px;">{{ pb.pb_name }}</td>
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
            <!-- <div class="pagination justify-content-end">
                <el-pagination
                    layout="prev, pager, next"
                    :page-size="page_ret.page_size"
                    :current-page="page_ret.current_page"
                    :total="page_ret.total"
                />
            </div> -->
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import NavBarSec from "@/components/NavBarSec.vue";
import $ from "jquery";
import { reactive, ref } from "vue";

export default {
    name: "ProblemSetView",
    components: {
        ContentBase,
        NavBarSec,
    },
    setup() {
        let tableDate = ref([]); // 题目列表
        // let page_size = ref(""); // 每页展示条数
        // let total = ref(""); // 总记录数
        // let current_page = ref(""); // 当前页
        // let total_page = ref(""); // 总页数
        let page_ret = reactive({
            page_size: 15,
            current_page: 1,
            total: "",
        });

        const get_problem_list = () => {
            $.ajax({
                url: "http://localhost:8091/problem/list/",
                type: "get",
                data: {
                    current_page: page_ret.current_page,
                    page_size: page_ret.page_size,
                },
                success(resp) {
                    tableDate.value = resp.problems_list;
                    page_ret = resp.page_list[0];
                },
            });
        };

        get_problem_list();

        return {
            tableDate,
            page_ret,
        };
    },
};
</script>

<style scoped>
</style>
