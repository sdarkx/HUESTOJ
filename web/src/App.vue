<template>
    <NavBar />
    <router-view />
</template>

<script>
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap";
import NavBar from "./components/NavBar.vue";
// import $ from 'jquery'

export default {
    name: "App",
    data() {},
    components: {
        NavBar,
    },
    methods: {},
    setup() {
        // $.ajax({
        //     url: "http://localhost:8091/user/account/token/",
        //     type: "post",
        //     data: {
        //         username: "3522954997@qq.com",
        //         password: "123",
        //     },
        //     success(resp) {
        //         console.log(resp);
        //     },
        //     error(resp) {
        //         console.log(resp);
        //     }
        // });
    },
};
</script>

<style scoped>
</style>
