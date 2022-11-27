<template>
    <NavBarSec />
    <ContentBase>
        <!-- 改成列表 我是sb用表格 -->
        <div>
            <el-table
                :data="tableData"
                size="0"
                table-layout="fixed"
                fit="false"
                border="true"
                style="width: 100%"
                :header-cell-style="{ 'text-align': 'center' }"
            >
                <el-table-column
                    prop="id"
                    label="#"
                    align="center"
                    width="60%"
                ></el-table-column>
                <el-table-column
                    prop="name"
                    label="Name"
                    align="left"
                    width="950%"
                />
                <el-table-column
                    prop="rating"
                    label="Rating"
                    align="center"
                    width="120%"
                />
                <el-table-column
                    prop="accept"
                    label="Accept"
                    align="center"
                    width="130%"
                />
            </el-table>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from "../../components/ContentBase.vue";
import NavBarSec from '@/components/NavBarSec.vue'

import { ElTable } from "element-plus";

export default {
    name: "ProblemSetView",
    components: {
        ContentBase,
        ElTable,
        NavBarSec,
    },
    methods: {
    },
    data() {
        return {
            tableData: [
                {
                    id: "1000",
                    name: "A+B problem",
                    rating: "900",
                    accept: "13478",
                },
                {
                    id: "1001",
                    name: "binary search",
                    rating: "1000",
                    accept: "9845",
                },
                {
                    id: "1002",
                    name: "tree",
                    rating: "1200",
                    accept: "3483",
                },
                {
                    id: "1003",
                    name: "Friday",
                    rating: "3500",
                    accept: "628",
                },
            ],
        };
    },
};
</script>

<style scoped>
</style>
