import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/homeview/HomeView.vue'
import ProblemSetView from '../views/problemview/ProblemSetView.vue'
import StatusView from '../views/statusview/StatusView.vue'
import ContestView from '../views/contestview/ContestView.vue'
import RatingView from '../views/ratingview/RatingView.vue'
import NotFoundView from '../views/notfoundview/NotFoundView.vue'
import EnterView from '../views/userview/account/EnterView.vue'
import RegisterView from '../views/userview/account/RegisterView.vue'
import WikiView from '../views/wikiview/WikiView.vue'
import ProblemDescriptView from '../views/problemview/ProblemDescriptView.vue'
// 测试页面
import TestView from '../views/testview/TestView.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        redirect: "/home"
    },
    {
        path: '/home',
        name: 'HomeView',
        component: HomeView
    },
    {
        path: '/problemset',
        name: 'ProblemSetView',
        component: ProblemSetView
    },
    {
        path: '/status',
        name: 'StatusView',
        component: StatusView
    },
    {
        path: '/contest',
        name: 'ContestView',
        component: ContestView
    },
    {
        path: '/rating',
        name: 'RatingView',
        component: RatingView
    },
    {
        path: '/wiki',
        name: 'WikiView',
        component: WikiView
    },
    {
        path: '/404',
        name: 'NotFoundView',
        component: NotFoundView
    },
    {
        path: '/enter',
        name: 'EnterView',
        component: EnterView
    },
    {
        path: '/register',
        name: 'RegisterView',
        component: RegisterView
    },
    {
        path: '/problem/descript/',
        name: 'ProblemDescriptView',
        component: ProblemDescriptView
    },
    // 测试路由
    {
        path: '/ojcode',
        name: 'TestView',
        component: TestView
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/404",
        // 异常地址
    },
    //   {
    //     path: '/about',
    //     name: 'about',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    //   }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
