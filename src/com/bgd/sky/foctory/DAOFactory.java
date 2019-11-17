package com.bgd.sky.foctory;

import com.bgd.sky.dao.UserDAOProxy;

public class DAOFactory {
    public static UserDAOProxy getUserDAOInstance(){
        return new UserDAOProxy();
    }

}
