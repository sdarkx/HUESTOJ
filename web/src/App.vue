<template>
    <NavBar />
    <router-view />
</template>

<script>
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap";
import NavBar from "./components/NavBar.vue";

export default {
    name: "App",
    data() {},
    components: {
        NavBar,
    },
    methods: {},
};
</script>

<style scoped>
</style>
