package JDBC;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataBaseTest extends JDBCParent {
    public void baseTest(String sorgu) {
        ArrayList<ArrayList<String>> data = getListData(sorgu);
        for (ArrayList<String> sira : data) {
            System.out.println(sira);
        }
    }


    @Test
    public void firstQuery() {

        baseTest("select avg(salary) from salaries;");
    }

    @Test
    public void secondQuery() {
        baseTest("select * from dept_emp where dept_no='D003';\n");
    }

    @Test
    public void thirdQuery() {
        baseTest("select * from employees e " +
                "left join dept_emp de on e.emp_no = de.emp_no " +
                "left join departments d on de.dept_no = d.dept_no " +
                "where d.dept_name = 'Human Resources';");
    }

    @Test
    public void fourthQuery() {
        baseTest("select avg(s.salary) as average_salary from employees e " +
                "left join salaries s on e.emp_no = s.emp_no " +
                "where e.gender = 'M';");
    }

    @Test
    public void fifthQuery() {
        baseTest("select avg(s.salary) as average_salary from employees e " +
                "left join salaries s on e.emp_no = s.emp_no " +
                "where e.gender = 'F';");
    }

    @Test
    public void sixthQuery() {
        baseTest("select *, s.salary from employees e " +
                "left join dept_emp de on e.emp_no = de.emp_no " +
                "left join departments d on de.dept_no = d.dept_no " +
                "left join salaries s on e.emp_no = s.emp_no " +
                "where d.dept_name = 'Sales' and s.salary > 70000;");
    }

    @Test
    public void seventhQuery() {
        baseTest("select * from employees e " +
                "left join salaries s on e.emp_no = s.emp_no " +
                "where s.salary between 50000 and 100000;");
    }

    @Test
    public void eighthQuery() {
        baseTest("select de.dept_no, avg(s.salary) as average_salary " +
                "from dept_emp de " +
                "left join salaries s on de.emp_no = s.emp_no " +
                "group by de.dept_no;");
    }

    @Test
    public void ninthQuery() {
        baseTest("select dept_name, avg(salary) as avg_salary\n" +
                "from departments\n" +
                "left join dept_emp on departments.dept_no = dept_emp.dept_no\n" +
                "left join salaries on dept_emp.emp_no = salaries.emp_no\n" +
                "group by departments.dept_no;");
    }

    @Test
    public void tenthQuery() {
        baseTest("select d.dept_no, d.dept_name, avg(s.salary) as average_salary " +
                "from employees e " +
                "left join dept_emp de on e.emp_no = de.emp_no " +
                "left join salaries s on e.emp_no = s.emp_no " +
                "left join departments d on de.dept_no = d.dept_no " +
                "group by d.dept_no, d.dept_name;");
    }

    @Test
    public void eleventhQuery() {
        baseTest("select emp_no, salary, from_date, to_date from salaries where emp_no = '10102' order by from_date;");
    }

    @Test
    public void twelvethQuery() {
        baseTest("select e.emp_no, e.first_name, e.last_name, s.salary\n" +
                "from employees e\n" +
                "left join salaries s on e.emp_no = s.emp_no\n" +
                "Order by s.salary desc\n" +
                "limit 1;");
    }

    @Test
    public void thirteenthQuery() {
        baseTest("select emp_no, salary, to_date from salaries where (emp_no, to_date) in (select emp_no, max(to_date) from salaries group by emp_no);");
    }

    @Test
    public void fourteenthQuery() {
        baseTest("select e.first_name, e.last_name, max(s.salary) as highest_salary " +
                "from employees e " +
                "inner join dept_emp de on e.emp_no = de.emp_no " +
                "inner join departments d on de.dept_no = d.dept_no " +
                "inner join salaries s on e.emp_no = s.emp_no " +
                "where d.dept_name = 'Sales' " +
                "group by e.first_name, e.last_name " +
                "order by highest_salary desc " +
                "limit 1;");
    }

    @Test
    public void fifteenthQuery() {
        baseTest("select e.first_name, e.last_name, max(s.salary) as max_salary " +
                "from employees e " +
                "inner join dept_emp de on e.emp_no = de.emp_no " +
                "inner join departments d on de.dept_no = d.dept_no " +
                "inner join salaries s on e.emp_no = s.emp_no " +
                "where d.dept_name = 'Research' " +
                "group by e.first_name, e.last_name " +
                "order by max_salary desc " +
                "limit 1;");
    }

    @Test
    public void sixteenthQuery() {
        baseTest("select d.dept_name as department, e.first_name, e.last_name, max(s.salary) as max_salary " +
                "from employees e " +
                "inner join dept_emp de on e.emp_no = de.emp_no " +
                "inner join departments d on de.dept_no = d.dept_no " +
                "inner join salaries s on e.emp_no = s.emp_no " +
                "group by d.dept_name " +
                "order by max_salary desc;");
    }

    @Test
    public void seventeenthQuery() {
        baseTest("select d.dept_name as department, e.first_name, e.last_name, avg(s.salary) as avg_salary " +
                "from employees e " +
                "inner join dept_emp de on e.emp_no = de.emp_no " +
                "inner join departments d on de.dept_no = d.dept_no " +
                "inner join salaries s on e.emp_no = s.emp_no " +
                "group by department " +
                "order by avg_salary desc;");
    }

    @Test
    public void eighteenthQuery() {
        baseTest("select first_name, last_name, hire_date from employees " +
                "where hire_date < '1990-01-01' " +
                "order by first_name asc, last_name asc;");
    }

    @Test
    public void nineteenthQuery() {
        baseTest("select first_name, last_name, hire_date from employees " +
                "where hire_date between '1985-01-01' and '1989-12-31' " +
                "order by hire_date asc;");
    }

    @Test
    public void twentiethQuery() {
        baseTest("select e.first_name, e.last_name, e.hire_date, s.salary " +
                "from employees e " +
                "join dept_emp de on e.emp_no = de.emp_no " +
                "join departments d on de.dept_no = d.dept_no " +
                "join salaries s on e.emp_no = s.emp_no " +
                "where e.hire_date between '1985-01-01' and '1989-12-31' " +
                "and d.dept_name = 'Sales' " +
                "order by s.salary desc;");
    }

    @Test
    public void twentyFirstQuery_a() {
        baseTest("select count(gender) as male_count from employees where gender = 'm';");
    }

    @Test
    public void twentyFirstQuery_b() {
        baseTest("select count(gender) as female_count from employees where gender = 'f';");
    }

    @Test
    public void twentyFirstQuery_c() {
        baseTest("select gender, count(*) as count from employees group by gender;");
    }

    @Test
    public void twentyFirstQuery_d() {
        baseTest("select count(emp_no) as total_employees from employees;");
    }

    @Test
    public void twentySecondQuery_a() {
        baseTest("select count(distinct first_name) as unique_names from employees;");
    }

    @Test
    public void twentySecondQuery_b() {
        baseTest("select count(distinct dept_name) as unique_departments from departments;");
    }

    @Test
    public void twentyThirdQuery() {
        baseTest("select de.dept_no, count(*) as employee_count from dept_emp de group by de.dept_no;");
    }

    @Test
    public void twentyFourthQuery() {
        baseTest("select * from employees where hire_date <= date_sub('1990-02-20', interval 5 year);");
    }

    @Test
    public void twentyFifthQuery() {
        baseTest("select * from employees where first_name = 'annemarie' and last_name = 'redmiles';");
    }

    @Test
    public void twentySixthQuery() {
        baseTest("select * from employees e " +
                "inner join salaries s on e.emp_no = s.emp_no " +
                "inner join titles t on e.emp_no = t.emp_no " +
                "where e.first_name = 'annemarie' and e.last_name = 'redmiles';");
    }

    @Test
    public void twentySeventhQuery() {
        baseTest("select e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, d.dept_name as department_name, t.title, s.salary " +
                "from employees e " +
                "join dept_manager dm on e.emp_no = dm.emp_no " +
                "join departments d on dm.dept_no = d.dept_no " +
                "join titles t on e.emp_no = t.emp_no " +
                "join salaries s on e.emp_no = s.emp_no " +
                "where d.dept_no = 'd005';");
    }

    @Test
    public void twentyEighthQuery() {
        baseTest("select e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, t.title, s.salary " +
                "from employees e " +
                "join titles t on e.emp_no = t.emp_no " +
                "join salaries s on e.emp_no = s.emp_no " +
                "where e.hire_date > '1994-02-24' and s.salary > 50000;");
    }

    @Test
    public void twentyNinthQuery() {
        baseTest("select e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date " +
                "from employees e " +
                "join dept_manager dm on e.emp_no = dm.emp_no " +
                "join departments d on dm.dept_no = d.dept_no " +
                "join titles t on e.emp_no = t.emp_no " +
                "where d.dept_name = 'sales' and t.title = 'manager';");
    }
}
