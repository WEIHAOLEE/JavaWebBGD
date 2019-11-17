package com.bgd.sky.dao;

import com.bgd.sky.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDapImpl implements UserDAO {
    private Connection con;
    private PreparedStatement pstm;

    public UserDapImpl(Connection conn){
        this.con=conn;
    }



    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean find(User user) throws Exception {
        boolean flag = false;
        String sql = "select * from web.user where name=? and password=?";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setString(2, user.getPassword());
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            flag = true;
            pstm.close();
        }
        return flag;
    }
}
