package JDBC;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataBaseTest extends JDBCParent{

    @Test
    public void firstQuery(){
        ArrayList<ArrayList<String>> data=getListData("select * from dept_emp where dept_no='D003';");
        for(ArrayList<String> sira : data){
            System.out.println(sira);
        }
    }
}
