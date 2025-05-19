package JDBC;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataBaseTest extends JDBCParent {
    public void baseTest(String sorgu){
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
    public void secondQuery(){
        baseTest("select * from dept_emp where dept_no='D003';\n");
    }
    @Test
    public void twelvethQuery(){
      baseTest("SELECT e.emp_no, e.first_name, e.last_name, s.salary\n" +
              "FROM employees e\n" +
              "JOIN salaries s ON e.emp_no = s.emp_no\n" +
              "ORDER BY s.salary DESC\n" +
              "LIMIT 1;");
    }
}
