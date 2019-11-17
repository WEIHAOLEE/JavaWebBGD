package com.bgd.sky.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/web?serverTimezone=GMT%2B8&useSSL=false";
    private static final String DBUSER="root";
    private static final String DBPASSWORD="12345678";
    private Connection con = null;


    public DBC() throws Exception{
        try {
            Class.forName(DBDRIVER);
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void close() throws Exception{
        if (con != null){
            try {
                con.close();
            }catch (Exception e){
                throw e;
            }
        }
    }
}
