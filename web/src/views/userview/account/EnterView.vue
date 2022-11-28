<template>
    <div class="loginRoot">
        <div class="loginTitle">
            <p>登录</p>
        </div>
        <el-form
            :model="loginform"
            ref="loginform"
            class="demo-ruleForm"
            status-icon
            label-position="right"
            label-width="80px"
        >
            <!-- 邮箱 -->
            <el-form-item
                prop="uEmail"
                label="邮箱"
                :rules="[
                    {
                        required: true,
                        message: '请输入邮箱地址',
                        trigger: 'blur',
                    },
                    {
                        type: 'email',
                        message: '请输入正确的邮箱地址',
                        trigger: ['blur', 'change'],
                    },
                ]"
            >
                <el-input v-model="loginform.uEmail"></el-input>
            </el-form-item>
            <!-- 密码 -->
            <el-form-item
                prop="uPassword"
                label="密码"
                :rules="[
                    {
                        required: true,
                        message: '请输入密码',
                        trigger: 'blur',
                    },
                ]"
            >
                <el-input
                    type="password"
                    v-model="loginform.uPassword"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-button
                    type="primary"
                    style="width: 88%"
                    @click="submitForm('loginform')"
                    >登录</el-button
                >
            </el-form-item>
        </el-form>
        <div>
            <el-link
                @click="forgotpassword"
                style="font-size: 12px; margin-left: 21%; "
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

export default {
    name: "EnterView",
    components: {},
    props: {},
    data() {
        return {
            loginform: {
                uEmail: "",
                uPassword: "",
            },
        };
    },
    watch: {},
    methods: {
        // 两个页面跳转
        forgotpassword() {
            // 忘记密码没写
            router.push({ name: "EnterView" });
        },
        toregister() {
            router.push({ name: "RegisterView" });
        },
        // submit
        submitForm() {
            this.$refs.loginform.validate((valid) => {
                if (valid) {
                    console.log(this.loginform);
                    console.log("ok");
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
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
