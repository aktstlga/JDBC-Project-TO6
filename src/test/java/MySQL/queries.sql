-- 1
select * from dept_emp where dept_no = 'D001';

-- 2
select * from dept_emp where dept_no = 'D003';

-- 3
select avg(salary) as average_salary
from salaries;

-- 4
select avg(salaries.salary) as average_male_salary
from employees
join salaries on employees.emp_no=salaries.emp_no
where employees.gender='M';

-- 5
select avg(salaries.salary) as average_male_salary
from employees
join salaries on employees.emp_no=salaries.emp_no
where employees.gender='F';

-- 6
select employees.first_name, employees.last_name, employees.emp_no, salaries.salary, departments.dept_name
from employees.employees
left join salaries on employees.emp_no = salaries.emp_no
left join dept_emp on employees.emp_no = dept_emp.emp_no
left join departments on dept_emp.dept_no = departments.dept_no
where salaries.salary > 7000 and departments.dept_name='Sales';

-- 7
select employees.first_name, employees.last_name, employees.emp_no, salaries.salary
from employees.employees
left join salaries on employees.emp_no = salaries.emp_no
left join dept_emp on employees.emp_no = dept_emp.emp_no
where salaries.salary between 50000 and 100000;

-- 8
select d.dept_name, avg(s.salary) as average_salary
from employees e
join salaries s on e.emp_no = s.emp_no
join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
group by d.dept_name;

-- 9
select d.dept_name, avg(s.salary) as average_salary
from employees e
join salaries s on e.emp_no = s.emp_no
join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
group by d.dept_name;

-- 10
select * from salaries
where emp_no=10102;

-- 11
select *
from salaries
where emp_no = 10102
order by from_date;

-- 12
select e.emp_no, e.first_name, e.last_name, s.salary
from employees e
left join salaries s on e.emp_no=s.emp_no
order by s.salary desc
limit 1;

-- 13
select e.emp_no, e.first_name, e.last_name, s.salary, s.to_date
from employees e
left join salaries s on e.emp_no = s.emp_no
where (s.emp_no, s.to_date) in (
    select emp_no, MAX(to_date)
    from salaries
    group by emp_no
)
order by s.salary desc;

-- 14
select e.first_name, e.last_name, max(s.salary) as max_salary
from employees e
left join salaries s on e.emp_no = s.emp_no
left join dept_emp de on e.emp_no = de.emp_no
left join departments d on de.dept_no = d.dept_no
where d.dept_name = 'Sales'
group by e.emp_no, e.first_name, e.last_name
order by max_salary desc
limit 1;

-- 15
select e.first_name, e.last_name, max(s.salary) as max_salary
from employees e
left join salaries s on e.emp_no = s.emp_no
left join dept_emp de on e.emp_no = de.emp_no
left join departments d on de.dept_no = d.dept_no
where d.dept_name = 'Research'
group by e.emp_no, e.first_name, e.last_name
order by max_salary desc
limit 1;

-- 16
select d.dept_name as department, e.first_name, e.last_name, MAX(s.salary) as max_salary
from employees e
left join dept_emp de on e.emp_no = de.emp_no
left join departments d on de.dept_no = d.dept_no
left join salaries s on e.emp_no = s.emp_no
group by d.dept_name
order by max_salary desc;

-- 17
select d.dept_name as department, e.first_name, e.last_name, avg(s.salary) as avg_salary
from employees e
left join dept_emp de on e.emp_no = de.emp_no
left join departments d on de.dept_no = d.dept_no
left join salaries s on e.emp_no = s.emp_no
group by department
order by avg_salary desc;

-- 18
select first_name, last_name, hire_date
from employees
where hire_date < '1990-01-01'
order by first_name, last_name;

-- 19
select e.first_name, e.last_name, dm.from_date, dm.to_date
from employees e
left join dept_manager dm ON e.emp_no = dm.emp_no
where dm.from_date <= '1989-12-31' AND dm.to_date >= '1985-01-01'
order by dm.from_date;

-- 20
select distinct e.first_name, e.last_name, e.hire_date, s.salary
from employees e
left join dept_emp de on e.emp_no = de.emp_no
left join departments d on de.dept_no = d.dept_no
left join salaries s on e.emp_no = s.emp_no
where e.hire_date between '1985-01-01' and '1989-12-31'
and d.dept_name = 'Sales'
order by s.salary desc;

-- 21
-- a
select COUNT(gender) as Male_Count from employees where gender = 'M';
-- b
select COUNT(gender) as Female_Count from employees where gender = 'F';
-- c
select gender, COUNT(*) as count from employees group by gender;
-- d
select COUNT(emp_no) as Total_Employees from employees;

-- 22
-- a
select COUNT(distinct first_name) as Unique_Names from employees;
-- b
select COUNT(distinct dept_name) as Unique_Departments from departments;

-- 23
select d.dept_name, count(de.emp_no) as employee_count
from departments d
join dept_emp de on d.dept_no = de.dept_no
group by d.dept_name;

-- 24
select *
from employees
where hire_date <= DATE_SUB('1990-02-20', interval 5 year);

-- 25
select *
from employees
where first_name = 'Annemarie' and last_name = 'Redmiles';

-- 26
select *
from employees e
left join salaries s on e.emp_no = s.emp_no
left join titles t on e.emp_no = t.emp_no
where e.first_name = 'Annemarie' and e.last_name = 'Redmiles';

-- 27
select e.emp_no, e.first_name, e.last_name, 'Employee' as role
from employees e
join dept_emp de on e.emp_no = de.emp_no
where de.dept_no = 'D005'
union all
select e.emp_no, e.first_name, e.last_name, 'Manager' as role
from employees e
join dept_manager dm on e.emp_no = dm.emp_no
where dm.dept_no = 'D005';

-- 28
select e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, t.title, s.salary
from employees e
left join titles t on e.emp_no = t.emp_no
left join salaries s on e.emp_no = s.emp_no
where e.hire_date > '1994-02-24' and s.salary > 50000;

-- 29
select e.emp_no, e.first_name, e.last_name
from employees e
join dept_manager dm on e.emp_no = dm.emp_no
join departments d on dm.dept_no = d.dept_no
where d.dept_name = 'Sales';




















