<template>
  <!-- Login Screen -->
    <f7-page login-screen>
      <f7-login-screen-title>Login - SSV QUIZ</f7-login-screen-title>
      <f7-list form>
        <f7-list-item>
          <!-- <f7-label>Username</f7-label> -->
          <f7-input name="username" placeholder="Your Username/email" type="text"></f7-input>
        </f7-list-item>
        <f7-list-item>
          <!-- <f7-label>Password</f7-label> -->
          <f7-input name="password" type="password" placeholder="Your Password"></f7-input>
        </f7-list-item>
      </f7-list>
      <f7-list>
        <!-- Additional "checkbox" prop to enable checkbox list item -->
        <f7-list-item checkbox value="save2login" checked title="Save to login"></f7-list-item>
        <f7-list-item checkbox value="save2register" title="Register new"></f7-list-item>
      </f7-list>
      <f7-list>
        <f7-list-button title="Login" login-screen-close></f7-list-button>
        <f7-block-footer>
          <p>Welcome to version 1.0.0 SSV QUIZ</p>
        </f7-block-footer>
      </f7-list>
    </f7-page>
</template>

<script>
export default {}
</script>