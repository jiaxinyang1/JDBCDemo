package com.hakurei;
import  java.sql.*;
public class JDBC {

    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动类路径。由反射载入该类
    String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Study;";//数据库路径
    String userName = "hakurei";//用户名
    String userPwd = "hakurei";//密码
    Connection dbConn;
    Statement stmt;
    ResultSet rs;

    public JDBC()
    {
        init();



        

    }
    //初始化环境
    public void init()
    {

        try {
            Class.forName(driverName);//装载该类
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);//连接数据库
            System.out.println("Connection Successful!");

            stmt=dbConn.createStatement();

            //   stmt.executeUpdate("delete from C_jxy where  Cno=10");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //执行查询
    public void query()
    {
        try {
            rs=stmt.executeQuery("SELECT *FROM C_jxy");//执行查询
            while (rs.next())
            {
                String Cno=rs.getString("Cno");
                String Cname =rs.getString("Cname");
                String Cpno= rs.getNString("Cpno");
                String Ccredit=rs.getString("Ccredit");

                System.out.println(Cno+" "+Cname+" "+Cpno+" "+Ccredit);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //执行删除
    public  void delete()
    {
        try {
            stmt.executeUpdate("delete from C_jxy where Cno=15");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //执行插入
    public void insert()
    {
        try {
            stmt.executeUpdate("INSERT INTO C_jxy values ('10','Megumin','5','5')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //释放资源
    public void close()
    {

        //释放资源
        try {
            stmt.close();
            dbConn.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
