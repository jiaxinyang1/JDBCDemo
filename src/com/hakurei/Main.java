package com.hakurei;

import  java.sql.*;
public class Main {

    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Study;";
        String userName = "hakurei";
        String userPwd = "hakurei";
        Connection dbConn = null;
        Statement sql = null;
        ResultSet rs = null;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful!");

            sql=dbConn.createStatement();

            rs=sql.executeQuery("SELECT *FROM C_jxy");
            while (rs.next())
            {
                String Cno=rs.getString("Cno");
                String Cname =rs.getString("Cname");
                String Cpno= rs.getNString("Cpno");
                String Ccredit=rs.getString("Ccredit");

                System.out.println(Cno+" "+Cname+" "+Cpno+" "+Ccredit);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}
