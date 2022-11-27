<template>
    <div style="position: relative">
        <!-- As a heading -->
        <nav class="container navbar navbar-expand-lg navbar-white bg-white">
            <div class="container-fluid">
                <div>
                    <ul
                        class="navbar-nav"
                        style="
                            font-family: 宋体;
                            font-size: 18px;
                            font-weight: bolder;
                        "
                    >
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'HomeView' }"
                                >HOME</router-link
                            >
                        </li>
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'ProblemSetView' }"
                                >PROBLEMSET</router-link
                            >
                        </li>
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'StatusView' }"
                                >STATUS</router-link
                            >
                        </li>
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'ContestView' }"
                                >CONTESTS</router-link
                            >
                        </li>
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'RatingView' }"
                                >RATING</router-link
                            >
                        </li>
                        <li class="nav-item">
                            <router-link
                                class="nav-link"
                                :to="{ name: 'WikiView' }"
                                >WIKI</router-link
                            >
                        </li>
                    </ul>
                </div>
                <div>
                    <el-button>Search</el-button>
                    <!-- <form method="" action="/search">
                        <input class="search" name="query" value="">
                        <input
                            class=""
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                        />
                        <el-button>Default</el-button>
                        <button class="nva-second-search" type="submit">
                            Search
                        </button>
                    </form> -->
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
import { ElButton } from "element-plus";

export default {
    name: "NavBarSec",
    components: {
        ElButton,
    },
    methods: {
        enter() {
            this.$router.push("/enter");
        },
        register() {
            this.$router.push("/register");
        },
    },
};
</script>

<style scoped>
/* 第一层 */

/* 第二层 */
.container-fluid {
    margin: 0px;
    border-style: solid;
    border-width: 0.5px;
    border-left-color: transparent;
    border-right-color: transparent;
}
.search {
    border: 1px flex #d4d4d4;
    color: #666;
    font-size: 1rem;
    height: 16px;
    width: 9em;
    line-height: 16px;
    float: right;
    padding: 1px 1px 1px 20px;
    margin: 4px 1em 0 0;
    background: #dbd5d5 url(../assets/logo/search.svg) 2px 2px no-repeat;
}
.nva-second-search {
    background-color: #e3e3e3;
    padding: none;
    border: 1.5px solid #979b97;
}
a.router-link-active {
    color: rgb(49, 143, 219);
}
.el-button + .el-button {
    margin-left: -2px;
}
</style>
