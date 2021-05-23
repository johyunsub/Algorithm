use ssafydb;
-- 1) ‘Diana’ 사원과 같은 직무인 사원의 사번(employee_id), 이름(first_name),
-- 직무(job_id), 부서번호(department_id), 부서이름(department_name)을 출력하세요.
select e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where job_id in (select job_id
				 from employees
				 where employees.first_name = 'Diana');

-- 2) ‘Bruce’와 같은 매니저인 사원의 정보를 inline view로 사용하여 아래의 결과를 출력하세요.
-- 사번, 이름, 직무이름, 부서이름을 출력.
select e.employee_id, e.first_name, j.job_title, d.department_name
from (select manager_id
	  from employees
	  where first_name = 'Bruce') m join employees e join jobs j join departments d
on m.manager_id = e.manager_id
and j.job_id = e.job_id
and d.department_id = e.department_id;

-- 3) 모든 사원을 입사일 순으로 정렬하고 가장 오래된 순으로 6번째부터 10번째까지 사원의 정보를 출력하세요.
select a.employee_id, a.first_name, a.hire_date
from (select *
		from employees
        order by hire_date) a
limit 5, 5;