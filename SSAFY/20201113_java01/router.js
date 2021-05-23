import List from './list.js';
import add from './add.js';

Vue.use(VueRouter);
export default new VueRouter({
  mode: 'hash',
  routes: [
    {
      path: '/add',
      name: 'add',
      component: add,
    },
    {
      path: '/list',
      name: 'list',
      component: List,
    },
  ],
});
