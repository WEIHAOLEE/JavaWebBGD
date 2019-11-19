package com.bgd.sky.dao;

import com.bgd.sky.bean.User;

import java.util.List;

public interface UserDAO {
    public boolean insert(User user) throws Exception;
    public boolean find(User user) throws Exception;
    public List list();

}
