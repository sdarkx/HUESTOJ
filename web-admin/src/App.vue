<template>
  <div id="app">
     <MovieA v-for="movie in movies" :key="movie.id" :title="movie.title" :rating="movie.rating"></MovieA>
  </div>
</template>

<script>
import MovieA from './components/MovieA.vue'

export default {
    name: "App",
    data: function() {
        return {
            movies:[
                {id:1, title:'DARK', rating:1092},
                {id:2, title:'Autumn', rating:1292},
                {id:3, title:'jiangly', rating:3672}
            ]
        }
    },
    components:{
        MovieA
    }
}

</script>

<style scoped>
</style>
