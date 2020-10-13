use workshop;
-- 1) 30번 부서에 속한 사원의 이름과 부서번호 그리고 부서이름을 출력하라.
select e.ename, e.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where e.deptno = 30;
-- 2) 30번 부서에 속한 사원들의 모든 직업과 부서위치를 출력하라. (단, 직업 목록이 중복되지 않게 하라.)
select distinct e.job, d.loc
from emp e inner join dept d
on e.deptno = d.deptno
where e.deptno = 30;
-- 3) 커미션이 책정되어 있는 모든 사원의 이름, 부서이름 및 위치를 출력하라.
select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno
where e.comm is not null;
-- 4) 이름에 A가 들어가는 모든 사원의 이름과 부서 이름을 출력하라.
select e.ename, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename like "%A%";
-- 5) Dallas에서 근무하는 모든 사원의 이름, 직업, 부서번호 및 부서이름을 출력하라.
select e.ename, e.job, d.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where d.loc = 'Dallas';
-- 6) 사원이름 및 사원번호, 해당 관리자이름 및 관리자 번호를 출력하되, 각 컬럼명을 employee,emp#,manager,mgr#으로 표시하여 출력하라.
select e.ename employee, e.empno 'emp#', m.ename manager, m.empno 'mgr#'
from emp e inner join emp m
on m.mgr = e.empno;
-- 7) 모든 사원의 이름,직업,부서이름,급여 및 등급을 출력하라.
select e.ename, e.job, d.dname, e.sal, s.grade 
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal;
-- 8) Smith보다 늦게 입사한 사원의 이름 및 입사일을 출력하라.
select ename, hiredate
from emp
where hiredate > ( select hiredate
				   from emp
				   where ename = 'Smith');
-- 9) 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 관리자의 이름, 관리자의 입사일을 출력하되 
-- 각각 컬럼명을 Employee,EmpHiredate, Manager,MgrHiredate로 표시하여 출력하라.
select e.ename Employee, e.hiredate EmpHiredate, m.ename Manager, m.hiredate MgrHiredate
from emp e inner join emp m
on e.empno = m.mgr
where e.hiredate < m.hiredate;
-- 10) Smith와 동일한 부서에 속한 모든 사원의 이름 및 입사일을 출력하라. 단, Smith는 제외하고 출력하시오
select ename, hiredate
from emp
where deptno = (select deptno
				from emp
				where ename = 'Smith')
and ename != 'Smith';
-- 11) 자신의 급여가 평균 급여보다 많은 모든 사원의 사원 번호, 이름, 급여를 표시하는 질의를 작성하고 급여를 기준으로 결과를 내림차순으로 정렬하라.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
-- 12) 이름에 T가 들어가는 사원의 속한 부서에서 근무하는 모든 사원의 사원번호 및 이름을 출력하라.
select empno, ename
from emp
where deptno in (select distinct deptno
				from emp
				where ename like "%T%");
-- 13) 자신의 급여가 평균 급여보다 많고 이름에 T가 들어가는 사원과 동일한 부서에 근무하는 모든 사원의 사원 번호, 이름 및 급여를 출력하라.
select empno, ename, sal
from emp
where deptno in ( select deptno
				from emp
				where sal > (select avg(sal) from emp)
				and ename like "%T%");
-- 14) 직업이 Clerk 인 사원들보다 더 많은 급여를 받는 사원의 사원번호, 이름, 급여를 출력하되, 결과를 급여가 높은 순으로 정렬하라.
select empno, ename, sal
from emp
where sal > (select min(sal)
			 from emp
			 where job = 'Clerk')
order by sal desc;
-- 15) New York 에서 근무하는 사원과 급여 및 커미션이 같은 사원의 사원이름과 부서명을 출력하라.
select e1.ename, d1.dname
from emp e1 join dept d1 
on e1.deptno = d1.deptno
where (e1.sal, e1.comm) in (select e2.sal, e2.comm
							from emp e2 join dept d2
							on e2.deptno = d2.deptno
							where d2.loc = 'New York');