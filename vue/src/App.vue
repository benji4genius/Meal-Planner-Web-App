<template>
  <div id="capstone-app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->

      <!----ADDED THIS PART FOR THE CALEANDAR COMPONENT----->
      <div id="calendar"></div>
      <!---------------------------------------------------->
    </div>
    <router-view />
  </div>
</template>

<!---ADDED THIS PART HERE-->
<script>
export default {
  name: 'App',
};
</script>

<style scoped>
</style>




