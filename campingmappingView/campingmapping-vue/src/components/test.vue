<template>
    <div class="show">
        {{ message }}
    </div>
</template>
<script>
export default{
  data () {
    return {
      message: 'Hello Vue!!'
    }
  }

}
</script>

<style>
.show{
    background-color: aqua;
    font-size: 50px;
    text-align: center;
    color: blueviolet;
}
</style>
