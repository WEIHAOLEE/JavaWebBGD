package com.bgd.sky.dao;

import com.bgd.sky.bean.User;

public interface UserDAO {
    public boolean insert(User user);
    public boolean find(User user) throws Exception;
}
