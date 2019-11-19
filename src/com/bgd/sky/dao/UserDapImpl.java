package com.bgd.sky.dao;

import com.bgd.sky.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDapImpl implements UserDAO {
    private Connection con;
    private PreparedStatement pstm;

    public UserDapImpl(Connection conn){
        this.con=conn;
    }


    @Override
    public List list() {
        List list = null;
        try {
            String sql = "select * from web.user";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            list = new ArrayList();

            while (rs.next()){
                User user = new User();
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }




    @Override
    public boolean insert(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "insert into web.user(name, password) values(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            int cout = pstm.executeUpdate();

            if (cout == 1){
                flag = true;
                pstm.close();
            }
        } catch (Exception e){
            throw e;
        }
        return flag;
    }

    @Override
    public boolean find(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "select * from web.user where name=? and password=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                flag = true;
                pstm.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return flag;

    }
}
