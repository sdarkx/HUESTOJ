<template>
    <!-- 此页面有一个神奇的bug -->
    <div>
        <ContentBase>
            <div>
                <el-header>
                    <el-button
                        text
                        style="margin-left: -20px"
                        @click="$router.back(-1)"
                        >back</el-button
                    >
                </el-header>
            </div>
            <div><hr style="margin-top: -20px" /></div>
            <div>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th style="width: 7%; text-align: center">#</th>
                            <th style="width: 15%; text-align: center">When</th>
                            <th style="width: 7%; text-align: center">Who</th>
                            <th style="width: 10%; text-align: center">
                                Problem
                            </th>
                            <th style="width: 7%; text-align: center">Lang</th>
                            <th style="width: 10%; text-align: center">
                                verdict
                            </th>
                            <th style="width: 7%; text-align: center">time</th>
                            <th style="width: 10%; text-align: center">
                                memory
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="st in status" :key="st.id">
                            <td style="text-align: center">{{ st.id }}</td>
                            <td style="text-align: left; font-size: 14px">
                                {{ st.when }}
                            </td>
                            <td style="text-align: center">
                                {{ st.who }}
                            </td>
                            <td style="text-align: center">
                                {{ st.problem }}
                            </td>
                            <td style="text-align: center">
                                {{ st.lang }}
                            </td>

                            <td
                                style="
                                    text-align: center;
                                    color: rgb(128, 128, 128);
                                "
                                v-if="st.verdict === 'Pending'"
                            >
                                {{ st.verdict }}
                            </td>
                            <td
                                style="text-align: center; color: green"
                                v-else-if="st.verdict === 'Accepted'"
                            >
                                {{ st.verdict }}
                            </td>
                            <td
                                style="text-align: center; color: blue"
                                v-else-if="st.verdict === 'Wrong Answer'"
                            >
                                {{ st.verdict }}
                            </td>

                            <td style="text-align: center" v-if="st.time === null || st.time === ''">
                                null
                            </td>
                            <td style="text-align: center" v-else>
                                {{ st.time }}
                            </td>
                            <td style="text-align: center" v-if="st.memory === null || st.memory === ''">
                                null
                            </td>
                            <td style="text-align: center" v-else>
                                {{ st.memory }}
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </ContentBase>
    </div>
</template>


<script>
import ContentBase from "../../components/ContentBase.vue";
import { ref } from "vue";
import { useStore } from "vuex";
import router from "../../router/index";

export default {
    name: "UserStatus",
    components: {
        ContentBase,
    },
    setup() {
        let status = ref([]);

        const store = useStore();
        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.dispatch("getuserstatus", {
                success(resp) {
                    console.log(resp);
                    status.value = resp;
                },
                error(resp) {
                    console.log(resp);
                    router.push({ name: "EnterView" });
                },
            });
        }

        return {
            status,
        };
    },
};
</script>


<style scoped>
</style>

