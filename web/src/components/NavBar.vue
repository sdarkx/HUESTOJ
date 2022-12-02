<template>
    <div style="position: relative">
        <!-- heading up -->
        <nav class="container navbar navbar-white bg-white">
            <div class="container-fluid" style="border: 1px solid transparent">
                <div class="up-logo">
                    <img
                        @click="routerhome"
                        class=""
                        src="../assets/logo/logo2.png"
                        style="height: 50px"
                    />
                </div>
                <div>
                    <div v-if="$store.state.user.is_login">
                        <el-dropdown>
                            <el-button v-if="!$store.state.user.nickname !== null">
                                {{ $store.state.user.nickname }}<arrow-down />
                            </el-button>
                            <el-button v-else-if="!$store.state.user.username !== null">
                                {{ $store.state.user.username }}<arrow-down />
                            </el-button>
                            <template #dropdown>
                                <el-dropdown-menu>
                                    <el-dropdown-item
                                        >You Profile</el-dropdown-item
                                    >
                                    <el-dropdown-item @click="logout"
                                        >Logout</el-dropdown-item
                                    >
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </div>
                    <div v-else-if="!$store.state.user.is_login">
                        <el-button
                            link="true"
                            @click="enter"
                            style="font-size: 17px"
                            >Enter</el-button
                        >
                        |
                        <el-button
                            link="true"
                            @click="register"
                            style="font-size: 17px; margin-left: -2px"
                            >Register</el-button
                        >
                    </div>
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
import { ElButton, ElMessage } from "element-plus";
import { useRoute } from "vue-router";
import { computed } from "vue";
import { useStore } from "vuex";

export default {
    name: "NavBar",
    components: {
        ElButton,
    },
    setup() {
        const store = useStore();
        const route = useRoute();
        let route_name = computed(() => route.name);

        const logout = () => {
            store.dispatch("logout");
            ElMessage.info("退出登陆");
        };

        return {
            route_name,
            logout,
        };
    },
    methods: {
        enter() {
            this.$router.push("/enter");
        },
        register() {
            this.$router.push("/register");
        },
        routerhome() {
            this.$router.push("/home");
        },
    },
};
</script>

<style scoped>
/* 第一层 */

/* 第二层 */
/* .container-fluid {
    margin: 0px;
    border-style: solid;
    border-width: 0.5px;
    border-left-color: transparent;
    border-right-color: transparent;
}
.search {
    border: 1px flex #d4d4d4;
    color: #666;
    font-size: 1rem;
    height: 16px;
    width: 9em;
    line-height: 16px;
    float: right;
    padding: 1px 1px 1px 20px;
    margin: 4px 1em 0 0;
    background: #dbd5d5 url(../assets/logo/search.svg) 2px 2px no-repeat;
}
.nva-second-search {
    background-color: #e3e3e3;
    padding: none;
    border: 1.5px solid #979b97;
}
a.router-link-active {
    color: rgb(49, 143, 219);
}
.el-button + .el-button {
    margin-left: -2px;
} */
</style>
