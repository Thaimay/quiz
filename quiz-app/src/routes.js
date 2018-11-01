import HomePage from "./pages/home.vue";
import AboutPage from "./pages/about.vue";
import FormPage from "./pages/form.vue";
import LoginPage from "./pages/login.vue";
import DynamicRoutePage from "./pages/dynamic-route.vue";
import NotFoundPage from "./pages/not-found.vue";

import PanelLeftPage from "./pages/panel-left.vue";
import PanelRightPage from "./pages/panel-right.vue";

import FrameManage from "./pages/frame-manage.vue";

export default [
  {
    path: "/",
    component: HomePage
  },
  {
    path: "/panel-left/",
    component: PanelLeftPage
  },
  {
    path: "/panel-right/",
    component: PanelRightPage
  },
  {
    path: "/about/",
    component: AboutPage
  },
  {
    path: "/form/",
    component: FormPage
  },
  {
    path: "/login/",
    component: LoginPage
  },
  {
    path: "/dynamic-route/blog/:blogId/post/:postId/",
    component: DynamicRoutePage
  },
  {
    path: "/frame-manage/",
    component: FrameManage
  },
  {
    path: "(.*)",
    component: NotFoundPage
  }
];
