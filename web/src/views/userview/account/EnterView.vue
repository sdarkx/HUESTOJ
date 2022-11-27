<template>
    <div class="login-account">
        <div class="loginRoot" @click.prevent="useraccountlogin">
            <h3 class="loginTitle">登陆</h3>

            <!-- <el-form-item label="*账号">
                <el-input
                    type="text"
                    auto-complete="off"
                    placeholder="请输入用户名"
                ></el-input>
            </el-form-item>
            <el-form-item label="*密码">
                <el-input
                    type="password"
                    auto-complete="off"
                    placeholder="请输入密码"
                ></el-input>
            </el-form-item> -->
            <div class="form-floating mb-3">
                <input
                    type="email"
                    class="form-control"
                    id="floatingInput"
                    placeholder="name@example.com"
                />
                <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
                <input
                    type="password"
                    class="form-control"
                    id="floatingPassword"
                    placeholder="Password"
                />
                <label for="floatingPassword">Password</label>
            </div>

            <el-button style="width: 100%; margin-top: 15px;">登陆</el-button>
            <el-link
                @click="forgotpassword"
                style="font-size: 12px; margin-top: 5px"
                >忘记密码?</el-link
            >
            <el-link
                @click="toregister"
                style="font-size: 12px; margin-top: 5px; margin-left: 122px"
                >没有密码?点我注册</el-link
            >
        </div>
    </div>
</template>

<script>
import router from "../../../router/index";

export default {
    name: "ContestView",
    components: {},
    props: {},
    data() {
        return {};
    },
    watch: {},
    methods: {
        // 两个页面跳转
        forgotpassword() {
            router.push({ name: "EnterView" });
        },
        toregister() {
            router.push({ name: "RegisterView" });
        },
        // 登录
        useraccountlogin() {
            console.log("login");
        },
    },
};
</script>

<style scoped>
.loginRoot {
    border-radius: 15px;
    background-clip: padding-box;
    /* margin: 50px auto; */
    margin-top: 12%;
    margin-left: 38%;
    width: 350px;
    padding: 15px 35px;
    background: rgb(255, 255, 255);
    border: 1px solid #ffffff;
    box-shadow: 0 0 25px #c6c6c6;
}
.loginTitle {
    margin: 15px auto 20px auto;
    text-align: center;
    color: #543a3a;
}
</style>
