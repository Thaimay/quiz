<template>
  <f7-page :page-content="false">
    <f7-navbar>
      <f7-nav-left back-link="Back"></f7-nav-left>
      <f7-nav-title>Manage User</f7-nav-title>
      <f7-nav-right>
        <f7-link panel-open="right">
          <f7-icon f7="search"></f7-icon>
        </f7-link>
      </f7-nav-right>
      <f7-subnavbar>
        <f7-searchbar search-container=".search-list" search-in=".item-title"></f7-searchbar>
      </f7-subnavbar>
    </f7-navbar>

    <f7-toolbar tabbar labels bottom-md>
      <f7-link tab-link="#tab_home" icon-f7="home" text="Home" tab-link-active></f7-link>
      <f7-link tab-link="#tab_quiz" icon-f7="timer" text="Quiz"></f7-link>
      <f7-link tab-link="#tab_question" icon-f7="box" text="Question"></f7-link>
      <f7-link tab-link="#tab_category" icon-f7="bookmark" text="Category"></f7-link>
      <f7-link tab-link="#tab_user" icon-f7="person" text="User"></f7-link>
    </f7-toolbar>

    <!-- Start Make search backdrop for search bar -->
    <div class="searchbar-backdrop"></div>
    <!-- End Make search backdrop for search bar -->
    <f7-tabs swipeable>
      <f7-tab id="tab_home" class="page-content" tab-active>
        <TabHome></TabHome>
      </f7-tab>
      <f7-tab id="tab_quiz" class="page-content">
        <TabQuiz></TabQuiz>
      </f7-tab>
      <f7-tab id="tab_question" class="page-content">
        <TabQuestion></TabQuestion>
      </f7-tab>
      <f7-tab id="tab_category" class="page-content">
        <TabCategory></TabCategory>
      </f7-tab>
      <f7-tab id="tab_user" class="page-content">
        <TabUser></TabUser>
      </f7-tab>
    </f7-tabs>
  </f7-page>
</template>

<script>
import TabHome from "./tab-home.vue";
import TabQuiz from "./tab-quiz.vue";
import TabQuestion from "./tab-question.vue";
import TabCategory from "./tab-category.vue";
import TabUser from "./tab-user.vue";

export default {
  components: {
    TabHome,
    TabQuiz,
    TabQuestion,
    TabCategory,
    TabUser
  },
  data() {
    return {};
  }
};
</script>