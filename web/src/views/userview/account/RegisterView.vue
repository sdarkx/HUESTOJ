<template>
    <!-- ref被用来给元素或子组件注册引用信息（ID的替代者）应用在html标签上获取的是真实DOM元素，应用在组件标签上是组件实例对象（vc） -->
    <!-- 允许一个自定义组件在使用 v-model 时定制 prop 和 event。默认情况下，一个组件上的 v-model 会把 value 用作prop 且把 input 用作 event，但是一些输入类型比如单选框和复选框按钮可能想使用 value prop 来达到不同的目的。使用 model 选项可以回避这些情况产生的冲突。 -->
    <div class="loginRoot">
        <div class="loginTitle">
            <p>注册</p>
        </div>
        <el-form
            :model="registerform"
            ref="registerform"
            :rules="rules"
            class="demo-ruleForm"
            status-icon
            label-position="right"
            label-width="80px"
        >
            <!-- 昵称 -->
            <el-form-item label="昵称" prop="uNickname">
                <el-input
                    v-model="registerform.uNickname"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 邮箱 -->
            <el-form-item label="邮箱" prop="uEmail">
                <el-input
                    v-model="registerform.uEmail"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 密码 -->
            <el-form-item label="密码" prop="uPassword">
                <el-input
                    type="password"
                    v-model="registerform.uPassword"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 二次密码 -->
            <el-form-item label="确认密码" prop="checkPass">
                <el-input
                    type="password"
                    v-model="registerform.checkPass"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 绑定学号？真实姓名 学号 -->
            <el-form-item label="姓名" prop="uRealname">
                <el-input
                    v-model="registerform.uRealname"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <el-form-item label="学号" prop="uStuid">
                <el-input
                    v-model="registerform.uStuid"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 表单提交 -->
            <el-form-item>
                <el-button
                    type="primary"
                    style="width: 88%"
                    @click="submitForm('registerform')"
                    >注册</el-button
                >
            </el-form-item>
        </el-form>
        <div>
            <el-link
                @click="tologin"
                style="font-size: 12px; margin-left: 21%"
                >已有账号?点我登陆</el-link
            >
        </div>
    </div>
</template>
<script>
import router from "../../../router/index";

export default {
    name: "RegisterView",
    components: {},

    data() {
        var validatePass = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入密码"));
            } else {
                if (this.registerform.checkPass !== "") {
                    this.$refs.registerform.validateField("checkPass");
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请再次输入密码"));
            } else if (value !== this.registerform.checkPass) {
                callback(new Error("两次输入密码不一致!"));
            } else {
                callback();
            }
        };
        return {
            registerform: {
                uNickname: "",
                uEmail: "",
                uPassword: "",
                checkPass: "",
                uRealname: "",
                uStuid: "",
            },
            rules: {
                uNickname: [
                    {
                        required: true,
                    },
                ],
                uEmail: [
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
                uPassword: [
                    {
                        required: true,
                        validator: validatePass,
                        trigger: "blur",
                    },
                ],
                checkPass: [
                    {
                        required: true,
                        validator: validatePass2,
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    watch: {},
    methods: {
        // 两个页面跳转
        tologin() {
            router.push({ name: "EnterView" });
        },
        // 表单提交
        submitForm() {
            this.$refs.registerform.validate((valid) => {
                if (valid) {
                    console.log(this.registerform);
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
