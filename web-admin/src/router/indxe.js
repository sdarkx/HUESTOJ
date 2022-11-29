import VueRouter from 'vue-router'
import OJmonaco from '../components/CodeEditer.vue'


export default new VueRouter({
    routes: [
        {
            path: '/',
            name: 'home',
            redirect: "/"
        },
        {
            path: '/ojcoder',
            name: "ojmonaco",
            component: OJmonaco,
        },
    ]
})
