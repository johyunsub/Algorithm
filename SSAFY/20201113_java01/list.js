export default {
  template: `
    <div>
        <div class="container">
          <input type="text" class="col-md-10" id="name" ref="name" v-model="name"/>
          <button class="btn btn-success" @click="search">검색</button>
        </div>
        <div class="container" v-if="items.length">
            <table class="table">
                <tr>
                    <th>사원 아이디</th>
                    <th>사원명</th>
                    <th>부서</th>
                    <th>직책</th>
                    <th>연봉</th>
                </tr>
                <tr v-for="item in items">
                    <td>{{item.id}}</td>
                    <td>{{item.name}}</td>
                    <td v-if="item.dept_id===118">사장</td>
                    <td v-else-if="item.dept_id===110">기획부장</td>
                    <td v-else-if="item.dept_id===102">영업부</td>
                    <td v-else-if="item.dept_id===101">총무부</td>
                    <td v-else-if="item.dept_id===111">인사부장</td>
                    <td v-else-if="item.dept_id===112">기획부</td>
                    <td v-else-if="item.dept_id===113">영업대표이사</td>
                    <td v-else-if="item.dept_id===104">사원</td>
                    <td v-else-if="item.dept_id===105">사원</td>
                    <td v-else-if="item.dept_id===106">사원</td>
                    <td>{{item.title}}</td>
                    <td>{{item.salary}}</td>
                </tr>
            </table>
        </div>
        <div v-else>
        글이 없습니다.
        </div>
        <div class="container">
            <button class="btn btn-primary" @click="movePage">등록</button>
        </div>
    </div>
    
    
    `,
  data() {
    return {
      items: [],
      name: '',
    };
  },

  created() {
    axios
      .get('http://localhost:8097/hrmboot/api/employee/all')
      .then(({ data }) => {
        this.items = data;
      });
  },
  methods: {
    movePage() {
      this.$router.push('/add');
    },
    search() {
      let na = this.name;
      if (na == '') {
        axios
          .get('http://localhost:8097/hrmboot/api/employee/all')
          .then(({ data }) => {
            this.items = data;
          });
      } else {
        axios
          .get('http://localhost:8097/hrmboot/api/name?name=' + na)
          .then(({ data }) => {
            this.items = data;
          });
      }
    },
  },
};
