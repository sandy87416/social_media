package com.esun.socialmedia.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection{


    private static final String URL = "jdbc:mysql://127.0.0.1:3306/socialmedia?user=root&password=sandy&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
