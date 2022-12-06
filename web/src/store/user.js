import { ElMessage } from 'element-plus';
import $ from 'jquery'

export default {
    state: {
        id: "",
        username: "",
        nickname: "",
        token: "",
        is_login: false,
        pulling_info: true,
    },
    getters: {
    },
    mutations: {
        updateUser(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.nickname = user.nickname;
            state.is_login = user.is_login;
        },
        updateToken(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = "";
            state.username = "";
            state.nickname = "";
            state.token = "";
            state.is_login = false;
        },
        updatePullingInfo(state, pulling_info) {
            state.pulling_info = pulling_info;
        }
    },
    actions: {
        login(context, data) {
            $.ajax({
                url: "http://localhost:8091/user/account/token/",
                type: "post",
                data: {
                    username: data.username,
                    password: data.password,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        localStorage.setItem("jwt_token", resp.token);
                        context.commit("updateToken", resp.token);
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                }
            });
        },
        getinfo(context, data) {
            $.ajax({
                url: "http://localhost:8091/user/account/info/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + context.state.token,
                    // headers: 'Access-Control-Allow-Origin',
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        context.commit("updateUser", {
                            ...resp,
                            is_login: true,
                        });
                        data.success(resp);
                        ElMessage.success('获取信息成功')
                        // console.log(resp);
                    } else {
                        ElMessage.success('获取信息失败')
                        data.error(resp);
                    }
                },
                error(resp) {
                    ElMessage.error('获取信息失败')
                    data.error(resp);
                }
            })
        },
        logout(context) {
            localStorage.removeItem("jwt_token");
            context.commit("logout");
        },
        register(context, data) {
            $.ajax({
                url: "http://localhost:8091/user/account/register/",
                type: "post",
                data: {
                    username: data.username,
                    password: data.password,
                    checkPass: data.checkPass,
                    nickname: data.nickname,
                    realname: data.realname,
                    userstuid: data.userstuid,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                },
            })
        },
        get_verification_code(context, data) {
            $.ajax({
                url: "http://localhost:8091/user/account/get_verification_code/",
                type: "post",
                data: {
                    username: data.username,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                },
            })
        }
    },
    modules: {
    }
}
