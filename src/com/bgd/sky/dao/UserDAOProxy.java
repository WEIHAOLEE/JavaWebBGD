package com.bgd.sky.dao;

import com.bgd.sky.bean.User;
import com.bgd.sky.dataBase.DBC;

import java.util.List;

public class UserDAOProxy implements UserDAO {

    private DBC dbc = null;
    private UserDAO dao = null;

    @Override
    public List list() {
        return this.dao.list();
    }





    public UserDAOProxy(){
        try {
            this.dbc = new DBC();
        }catch (Exception e ){
            e.printStackTrace();
        }
        this.dao = new UserDapImpl(this.dbc.getConnection());
    }

    @Override
    public boolean insert(User user) throws Exception {
        boolean flag;
        flag = this.dao.insert(user);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean find(User user) throws Exception {
        boolean flag = false;
        flag = this.dao.find(user);
        this.dbc.close();
        return flag;
    }
}
