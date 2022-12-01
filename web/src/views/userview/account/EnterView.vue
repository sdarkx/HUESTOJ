<template>
    <div class="loginRoot">
        <div class="loginTitle">
            <p>登录</p>
        </div>
        <el-form
            :rules="loginformrules"
            :model="loginform"
            ref="loginformrules"
            class="demo-ruleForm"
            status-icon
            label-position="right"
            label-width="80px"
        >
            <!-- 邮箱 -->
            <el-form-item label="邮箱" prop="username">
                <el-input type="text" v-model="loginform.username"></el-input>
            </el-form-item>
            <!-- 密码 -->
            <el-form-item label="密码" prop="password">
                <el-input
                    type="password"
                    v-model="loginform.password"
                    show-password
                ></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" style="width: 88%" @click="submitform"
                    >登录</el-button
                >
            </el-form-item>
        </el-form>
        <div>
            <el-link
                @click="forgotpassword"
                style="font-size: 12px; margin-left: 21%"
                >忘记密码?</el-link
            >
            <el-link
                @click="toregister"
                style="font-size: 12px; margin-left: 143px"
                >没有账号?点我注册</el-link
            >
        </div>
    </div>
</template>

<script>
import router from "../../../router/index";
import { ElMessage } from "element-plus";
import { useStore } from "vuex";
import { reactive } from "vue";

export default {
    name: "EnterView",
    setup() {
        let loginform = reactive({
            username: "",
            password: "",
        });
        const loginformrules = reactive({
            username: [
                {
                    required: true,
                    message: "请输入邮箱地址",
                    trigger: "blur",
                },
                {
                    type: "email",
                    message: "请输入正确的邮箱地址",
                    trigger: ["blur", "change"],
                },
            ],
            password: [
                {
                    required: true,
                    message: "请输入密码",
                    trigger: "blur",
                },
            ],
        });

        const store = useStore();
        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getinfo", {
                success() {
                    router.push({ name: "home" });
                    store.commit("updatePullingInfo", false);
                },
                error() {
                    store.commit("updatePullingInfo", false);
                },
            });
        } else {
            store.commit("updatePullingInfo", false);
        }

        const submitform = () => {
            // 提交表单登录
            store.dispatch("login", {
                username: loginform.username,
                password: loginform.password,
                success() {
                    // 登陆成功
                    ElMessage.success("登陆成功");
                    store.dispatch("getinfo", {
                        success() {
                            router.push({ name: "home" });
                        },
                    });
                },
                error() {
                    // 登陆失败
                    ElMessage.error("登陆失败捏");
                },
            });
        };

        return {
            submitform,
            loginform,
            loginformrules,
        };
    },
    methods: {
        // 两个页面跳转
        forgotpassword() {
            // 忘记密码--还没写
            router.push({ name: "EnterView" });
        },
        toregister() {
            router.push({ name: "RegisterView" });
        },
    },
};
</script>

<style scoped>
.loginRoot {
    border-radius: 15px;
    background-clip: padding-box;
    /* margin: 50px auto; */
    margin-top: 8%;
    margin-left: 34%;
    width: 450px;
    padding: 15px 35px;
    background: rgb(255, 255, 255);
    border: 1px solid #ffffff;
    box-shadow: 0 0 25px #c6c6c6;
}
.loginTitle {
    margin: 15px auto 20px auto;
    text-align: center;
    color: #543a3a;
    font-size: 32px;
}
</style>