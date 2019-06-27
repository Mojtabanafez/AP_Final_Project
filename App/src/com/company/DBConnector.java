package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    //DB setting for PostgreSQL
    private final static String db_Driver = "org.postgresql.Driver";
    private final static String db_URL = "jdbc:postgresql://localhost:5432/ap_final_project";
    private final static String db_user="mojtaba";
    private final static String db_Pass="96431335";
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection ==null){
            try{
                Class.forName(db_Driver);
                connection = DriverManager.getConnection(db_URL,db_user,db_Pass);
                System.out.println("Connection is Created!");
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error Connection is failed!!");
            }
        }
        return connection;
    }
}