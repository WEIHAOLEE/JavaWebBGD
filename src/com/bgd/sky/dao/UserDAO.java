package com.bgd.sky.dao;

import com.bgd.sky.bean.Course;
import com.bgd.sky.bean.Student;
import com.bgd.sky.bean.StudentCourse;
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

    // StudentPage
    public boolean stuFind(Student student) throws Exception;

    // Course
    public boolean addCou(Course course) throws Exception;
    public boolean updateCou(Course course) throws Exception;
    public boolean delCou(Course course) throws Exception;
    public List couList();

    // Select Course
    public List sCouList(); //可选列表
    public List rSCouList(); //已选列表

    public boolean selectCou(Student student, Course course) throws Exception;

    public List studentCouList(); //sc表

    public boolean delSelectCou(StudentCourse studentCourse) throws Exception; //删除已选课程

}
