import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'font-awesome/css/font-awesome.min.css'
import VueRouter from 'vue-router';

Vue.use(ElementUI).use(VueRouter)

Vue.config.productionTip = false

new Vue({
    render: h => h(App),
}).$mount('#app')
