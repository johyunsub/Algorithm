export default {
  template: `
  <div>
  <h2 class="container text-info">SSAFY HRM ADD EMPLOEE</h2>
  <div id="add">
  <div class="container">
      <label for="name" class="col-md-2">이름</label>
      <input type="text" class="col-md-6" id="name" ref="name" v-model="name" />
    </div>
    <div class="container">
      <label for="email" class="col-md-2">이메일</label>
      <input type="email" class="col-md-6" id="email" ref="email" v-model="email" />
    </div>
    <div class="container">
      <label for="hire" class="col-md-2">고용일</label>
      <input type="date" class="col-md-6" id="hire" ref="hire" v-model="hire" />
    </div>
    
    <div class="container">
      <label for="title" class="col-md-2">직책</label>
      <select  class="col-md-6" ref="title" v-model="title">
        <option value="사장">사장</option>
        <option value="기획부장">기획부장</option>
        <option value="영업부장">영업부장</option>
        <option value="총무부장">총무부장</option>
        <option value="인사부장">인사부장</option>
        <option value="과장">과장</option>
        <option value="영업대표이사">영업대표이사</option>
        <option value="사원">사원</option>
      </select>
    </div>
    <div class="container">
      <label for="dept" class="col-md-2">부서</label>
      <select id="dept" class="col-md-6" ref="dept" v-model="dept">
        <option value="118">사장</option>
        <option value="110">기획부장</option>
        <option value="102">영업부</option>
        <option value="101">총무부</option>
        <option value="111">인사부장</option>
        <option value="112">기획부</option>
        <option value="113">영업대표이사</option>
        <option value="104">사원</option>
        <option value="105">사원</option>
        <option value="106">사원</option>
      </select>
    </div>
    <div class="container">
      <label class="col-md-2" for="salary">월급</label>
      <input type="number" class="col-md-6" id="salary" ref="salary" v-model="salary"/>
    </div>
    <div class="container" >
      <label for="com" class="col-md-2">커미션</label>
      <input type="number" class="col-md-6" id="com" ref="com" v-model="com" />
    </div>
    <div class="container">
      <button class="btn btn-primary" @click="checkHandler">등록</button>
    </div>
  </div>
  </div>
  `,
  data() {
    return {
      name: '',
      email: '',
      hire: '',
      title: '',
      dept: '',
      salary: 0,
      com: 0,
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      if (!this.name) {
        err = false;
        msg = '이름을 입력하세요';
        this.$refs.name.focus();
      } else if (!this.email) {
        err = false;
        msg = '이메일을 입력하세요';
        this.$refs.email.focus();
      } else if (!this.hire) {
        err = false;
        msg = '고용일을 입력하세요';
        this.$refs.hire.focus();
      } else if (!this.salary) {
        err = false;
        msg = '월급을 입력하세요';
        this.$refs.salary.focus();
      }
      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post('http://localhost:8097/hrmboot/api/employee', {
          name: this.name,
          mailid: this.email,
          start_date: this.hire,
          title: this.title,
          dept_id: this.dept,
          salary: this.salary,
          commission_pct: this.com,
        })
        .then(({ data }) => {
          let msg = '등록 처리시 문제가 발생했습니다.';
          console.log(data);
          if (data.state === 'succ') {
            msg = '등록이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push('/list');
    },
  },
};
