<template>
    <div class="login-account">
        <el-form class="loginRoot">
            <link rel="icon" href="../../assets/icons/user.svg" />
            <h3 class="loginTitle">登陆</h3>
            <el-form-item label="*账号">
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
            </el-form-item>
            <el-button style="width: 100%">登陆</el-button>
            <el-link href="/enter" style="font-size: 12px; margin-top: 5px"
                >忘记密码?</el-link
            >
            <el-link
                href="/register"
                style="font-size: 12px; margin-top: 5px; margin-left: 122px"
                >没有密码?点我注册</el-link
            >
        </el-form>
    </div>
</template>

<script>
export default {
    name: "ContestView",
    components: {},
    props: {},
    data() {
        return {};
    },
    watch: {},
    methods: {},
};
</script>

<style scoped>
.loginRoot {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 50px auto;
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
