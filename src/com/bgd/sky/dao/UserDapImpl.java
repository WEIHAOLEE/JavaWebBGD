package com.bgd.sky.dao;

import com.bgd.sky.bean.Course;
import com.bgd.sky.bean.Student;
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
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return false;
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



    // Student
    @Override
    public boolean addStu(Student student) throws Exception {
        boolean flag = false;
        try {
            String sql = "insert into web.student(sid,sname,sage,sclass) values(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, student.getSid());
            pstm.setString(2, student.getSname());
            pstm.setString(3, student.getSage());
            pstm.setString(4, student.getSclass());
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
    public boolean updateStu(Student student) throws Exception {
        boolean flag = false;
        try {
            String sql = "update web.student set sname=?,sage=?,sclass=? where sid=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, student.getSname());
            pstm.setString(2, student.getSage());
            pstm.setString(3, student.getSclass());
            pstm.setString(4, student.getSid());
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
    public boolean delStu(Student student) throws Exception {
        boolean flag = false;
        try {
            String sql = "delete from web.student where sid=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, student.getSid());
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
    public List stuList() {
        List stuList = null;
        try {
            String sql = "select * from web.student";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            stuList = new ArrayList();

            while (rs.next()){
                Student student = new Student();
                student.setSid(rs.getString(1));
                student.setSname(rs.getString(2));
                student.setSage(rs.getString(3));
                student.setSclass(rs.getString(4));
                stuList.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stuList;
    }


    // Course


    @Override
    public boolean addCou(Course course) throws Exception {
        boolean flag = false;
        try {
            String sql = "insert into web.course(cid, cname, cinr, credit) values(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, course.getCid());
            pstm.setString(2, course.getCname());
            pstm.setString(3, course.getCinr());
            pstm.setString(4, course.getCredit());
            int cout = pstm.executeUpdate();

            if (cout == 1) {
                flag = true;
                pstm.close();
            }


        }catch (Exception e){
            throw e;
        }
        return flag;
    }

    @Override
    public boolean updateCou(Course course) throws Exception {
        boolean flag = false;
        try {
            String sql = "update web.course set cname=?,cinr=?,credit=? where cid=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, course.getCname());
            pstm.setString(2, course.getCinr());
            pstm.setString(3, course.getCredit());
            pstm.setString(4, course.getCid());
            int cout = pstm.executeUpdate();

            if (cout == 1){
                flag = true;
                pstm.close();
            }

        }catch (Exception e){
            throw e;
        }
        return flag;
    }

    @Override
    public boolean delCou(Course course) throws Exception {
        boolean flag = false;
        try {
            String sql = "delete from web.course where cid=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, course.getCid());
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
    public List couList() {
        List couList = null;
        try{
            String sql = "select * from web.course";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            couList = new ArrayList();

            while (rs.next()){
                Course course = new Course();
                course.setCid(rs.getString(1));
                course.setCname(rs.getString(2));
                course.setCinr(rs.getString(3));
                course.setCredit(rs.getString(4));
                couList.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return couList;
    }
}
