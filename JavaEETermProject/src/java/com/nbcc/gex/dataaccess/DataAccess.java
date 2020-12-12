/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.CallableStatement;

/**
 *
 * @author Joe
 */
public class DataAccess {
    
    private static final String URL = "jdbc:mysql://localhost:3306/ATS?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1234";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return conn;
        } catch (SQLException sqle){
            return null;
        } catch (ClassNotFoundException cnfe){
            return null;
        }
    }

    public static ResultSet getResultSet(CallableStatement statement){
        ResultSet rs;
        
        try {
            statement.execute();
            rs = statement.getResultSet();
            return rs;
        } catch (SQLException sqle){
            return null;
        }
    }
    
    public static int update(CallableStatement statement){
        int rowCount = 0;
        
        try {
            rowCount = statement.executeUpdate();
            return rowCount;
        } catch (SQLException e){
            return 0;
        }
    }
}
