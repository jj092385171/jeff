// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import 'es6-promise/auto'
import 'normalize.css'
import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/zh-TW'
import lodash from 'lodash'
import moment from 'moment'
import fontawesome from '@fortawesome/fontawesome'
import regular from '@fortawesome/fontawesome-free-regular'
import solid from '@fortawesome/fontawesome-free-solid'
import brands from '@fortawesome/fontawesome-free-brands'
fontawesome.library.add(regular)
fontawesome.library.add(solid)
fontawesome.library.add(brands)
Vue.use(Vuex)
Vue.use(ElementUI, {locale})
Vue.prototype.$moment = moment
Vue.prototype.$lodash = lodash
Vue.config.productionTip = false

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
