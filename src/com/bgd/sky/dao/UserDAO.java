package com.bgd.sky.dao;

import com.bgd.sky.bean.Student;
import com.bgd.sky.bean.User;

import java.util.List;

public interface UserDAO {

    // User
    public boolean insert(User user) throws Exception;
    public boolean find(User user) throws Exception;


    public boolean update(User user) throws Exception;
    public boolean delete(User user) throws Exception;

    public List list();


    // Student
    public boolean addStu(Student student) throws Exception;
    public boolean updateStu(Student student) throws Exception;
    public boolean delStu(Student student) throws Exception;
    public List stuList();


    // Course
    public List couList();

}
