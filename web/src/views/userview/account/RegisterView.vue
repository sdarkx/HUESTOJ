<template>
    <!-- ref被用来给元素或子组件注册引用信息（ID的替代者）应用在html标签上获取的是真实DOM元素，应用在组件标签上是组件实例对象（vc） -->
    <!-- 允许一个自定义组件在使用 v-model 时定制 prop 和 event。默认情况下，一个组件上的 v-model 会把 value 用作prop 且把 input 用作 event，但是一些输入类型比如单选框和复选框按钮可能想使用 value prop 来达到不同的目的。使用 model 选项可以回避这些情况产生的冲突。 -->
    <div class="loginRoot">
        <div class="loginTitle">
            <p>注册</p>
        </div>
        <el-form
            :model="registerform"
            :rules="registerformrules"
            ref="registerformrules"
            class="demo-ruleForm"
            status-icon
            label-position="right"
            label-width="80px"
        >
            <!-- 邮箱 -->
            <el-form-item label="邮箱" prop="username">
                <el-input
                    v-model="registerform.username"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 密码 -->
            <el-form-item label="密码" prop="password">
                <el-input
                    type="password"
                    v-model="registerform.password"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 二次密码 -->
            <el-form-item label="确认密码" prop="checkPass">
                <el-input
                    type="password"
                    v-model="registerform.checkPass"
                    @blur="va2"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 昵称 -->
            <el-form-item label="昵称" prop="nickname">
                <el-input
                    v-model="registerform.nickname"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 绑定学号？真实姓名 学号 -->
            <el-form-item label="姓名" prop="uRealname">
                <el-input
                    v-model="registerform.realname"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <el-form-item label="学号" prop="uStuid">
                <el-input
                    v-model="registerform.userstuid"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <!-- 验证码 -->
            <el-form-item label="验证码" prop="verification_code">
                <el-input
                    v-model="registerform.verification_code"
                    style="width: 59%; margin-right: 20px"
                    autocomplete="off"
                ></el-input>
                <el-button @click="get_verification_code">获取验证码</el-button>
            </el-form-item>
            <!-- 表单提交 -->
            <el-form-item>
                <el-button
                    type="primary"
                    style="width: 88%"
                    @click="submitregisterForm"
                    >注册</el-button
                >
            </el-form-item>
        </el-form>
        <div>
            <el-link @click="tologin" style="font-size: 12px; margin-left: 21%"
                >已有账号?点我登陆</el-link
            >
        </div>
    </div>
</template>
<script>
import { reactive } from "vue";
import router from "../../../router/index";
import { ElMessage } from "element-plus";
import { useStore } from "vuex";

export default {
    name: "RegisterView",
    setup() {
        let registerform = reactive({
            username: "",
            password: "",
            checkPass: "",
            nickname: "",
            realname: "",
            userstuid: "",
            verification_code: "",
        });

        const registerformrules = reactive({
            // 账号 邮箱验证
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
            // 密码验证
            password: [
                {
                    required: true,
                    message: "请输入密码",
                    trigger: "blur",
                    // validator: validatePass,
                },
            ],
            checkPass: [
                {
                    required: true,
                    message: "请再次输入密码",
                    trigger: "blur",
                    // validator: validatePass2,
                },
            ],
            // 数据库非必须
            nickname: [
                {
                    required: true,
                    message: "请输入昵称",
                },
            ],
            verification_code: [
                {
                    required: true,
                    message: "请输入验证码",
                },
            ],
        });

        // 密码校验
        // var validatePass = (rule, value, callback) => {
        //     if (value === "") {
        //         callback(new Error("请输入密码"));
        //     } else {
        //         if (this.registerform.checkPass !== "") {
        //             this.$refs.registerform.validateField("checkPass");
        //         }
        //         callback();
        //     }
        // };
        // var validatePass2 = (rule, value, callback) => {
        //     if (value === "") {
        //         callback(new Error("请再次输入密码"));
        //     } else if (value !== this.registerform.checkPass) {
        //         // callback(new Error("两次输入密码不一致!"));
        //         this.registerform.checkPass.message = "两次密码不一致";
        //     } else {
        //         callback();
        //     }
        // };

        // 注册表单提交
        const store = useStore();
        const submitregisterForm = () => {
            ElMessage.success("提交成功");
            store.dispatch("register", {
                username: registerform.username,
                password: registerform.password,
                checkPass: registerform.checkPass,
                nickname: registerform.nickname,
                realname: registerform.realname,
                userstuid: registerform.userstuid,
                success() {
                    ElMessage.success("注册成功");
                    router.push({ name: "EnterView" });
                },
                error(resp) {
                    ElMessage.warning(resp.error_message);
                },
            });
        };
        // 验证发送
        const get_verification_code = () => {
            if(registerform.username === null){
                ElMessage.error("账户不能为空");
            }
            store.dispatch("get_verification_code", {
                username: registerform.username,
                success() {
                    ElMessage.success("获取成功");
                },
                error(resp) {
                    ElMessage.error();
                    ElMessage.warning(resp.error_message);
                },
            });
        };

        return {
            registerform,
            registerformrules,
            submitregisterForm,
            get_verification_code,
        };
    },
    methods: {
        // 两个页面跳转
        tologin() {
            router.push({ name: "EnterView" });
        },
        va2() {
            if (this.registerform.password !== this.registerform.checkPass)
                ElMessage.error("两次密码不一致");
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
