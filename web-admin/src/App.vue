<template>
    <div id="app">
        <div>
            <MovieA
                v-for="movie in movies"
                :key="movie.id"
                :title="movie.title"
                :rating="movie.rating"
            ></MovieA>
        </div>
        <br>
        <div>
            <a href="https://www.baidu.com">这是一个超链接</a><br>
            <router-link :to="{ name: 'ojcoder' }">ojcoder</router-link>
        </div>
        <br>
        <div>
            <monaco-editor style="width:800px; height:500px;margin-left:15%;" />
        </div>
    </div>
    <!-- vue2每个template内有一个div标签 -->
</template>

<script>
import MovieA from "./components/MovieA.vue";
import monacoEditor  from './components/CodeEditer.vue'

export default {
    name: "App",
    data: function () {
        return {
            movies: [
                { id: 1, title: "DARK", rating: 1092 },
                { id: 2, title: "Autumn", rating: 1292 },
                { id: 3, title: "jiangly", rating: 3672 },
            ],
        };
    },
    components: {
        MovieA,
        monacoEditor,
    },
};
</script>

<style scoped>
</style>
