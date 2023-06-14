package com.zhang.util;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.util
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:52
 * @Description: TODO
 * @Version: 1.0
 */
public class JDBCUtil {
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dormitory?serverTimezone=GMT%2B8"; //
    private static String user = "root";
    private static String password = "333"; //Test123.

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                connection.close();
            }
            if(resultSet != null){
                connection.close();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

/*    public static void main(String[] args) {
        System.out.println(JDBCUtil.getConnection());
    }*/
}
