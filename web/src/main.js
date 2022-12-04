import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/assets/css/global.css'
// import Vue from 'vue'

// 引入markdown解析js marked+语法高亮样式
import hljs from 'highlight.js';
import 'highlight.js/styles/atom-one-dark.css'

// 引入 preview 组件来渲染markdown
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
VMdPreview.use(githubTheme, {
    Hljs: hljs,
});

// 引入你所使用的主题 此处以 github 主题为例
import githubTheme from '@kangc/v-md-editor/lib/theme/github';
import '@kangc/v-md-editor/lib/theme/style/github.css';

// emelentplus
// vue3使用emement-plus vue2使用elementui
import Element_Plus from 'element-plus'
import 'element-plus/dist/index.css'

// 代码编辑器


createApp(App).use(store).use(router).use(Element_Plus).use(VMdPreview).mount('#app')
// .mount('#app')必须放在最后面 不然排在他后边的组件vue渲染不上 tmd SB死了弄了一下午弄不好一次手贱就好了

// marked 要用花括号括起来 不然会报错 猜想就是注册组件都要括 自己写的不用
// import { marked } from 'marked'
// const markedMixin = {
//     methos: {
//         md: function (input) {
//             return marked(input);
//         }
//     }
// };