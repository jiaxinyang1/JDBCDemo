package com.hakurei;


public class Main {


    public static void main(String[] args) {
        JDBC jdbc=new JDBC();
        jdbc.query();
        jdbc.delete();





        jdbc.close();

    }
}
