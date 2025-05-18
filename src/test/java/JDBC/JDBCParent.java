package JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.*;
import java.util.ArrayList;

public class JDBCParent {
    public static Connection baglanti;
    public static Statement sorguEkrani;


    public static void DBConnectionOpen() {
        String serverUrl = "jdbc:mysql://demo.mersys.io:33906/employees";  //port,dbname,mySql
        String username = "student";
        String password = "DEkzTd3#pzPm";

        try {
            baglanti = DriverManager.getConnection(serverUrl, username, password);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }


    public static void DBConnectionClose() {
        try {
            baglanti.close();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static ArrayList<ArrayList<String>> getListData(String sorgu) {
        ArrayList<ArrayList<String>> donecekTablo = new ArrayList<>();
        DBConnectionOpen();
        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    satir.add(rs.getString(i));
                }

                donecekTablo.add(satir);
            }
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBConnectionClose();
        return donecekTablo;
    }
}
