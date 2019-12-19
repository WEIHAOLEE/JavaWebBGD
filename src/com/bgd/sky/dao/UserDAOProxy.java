package com.bgd.sky.dao;

import com.bgd.sky.bean.Course;
import com.bgd.sky.bean.Student;
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

    @Override
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return false;
    }


    //Student

    @Override
    public boolean addStu(Student student) throws Exception {
        boolean flag;
        flag = this.dao.addStu(student);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean updateStu(Student student) throws Exception {
        boolean flag;
        flag = this.dao.updateStu(student);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean delStu(Student student) throws Exception {
        boolean flag;
        flag = this.dao.delStu(student);
        this.dbc.close();
        return flag;
    }

    @Override
    public List stuList() {
        return this.dao.stuList();
    }

    @Override
    public boolean stuFind(Student student) throws Exception {
        boolean flag;
        flag = this.dao.stuFind(student);
        this.dbc.close();
        return flag;
    }

    // Course


    @Override
    public boolean addCou(Course course) throws Exception {
        boolean flag;
        flag = this.dao.addCou(course);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean updateCou(Course course) throws Exception {
        boolean flag;
        flag = this.dao.updateCou(course);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean delCou(Course course) throws Exception {
        boolean flag;
        flag = this.dao.delCou(course);
        this.dbc.close();
        return flag;
    }

    @Override
    public List couList() {
        return this.dao.couList();
    }
}
