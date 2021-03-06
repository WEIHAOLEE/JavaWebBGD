package com.bgd.sky.dao;

import com.bgd.sky.bean.Course;
import com.bgd.sky.bean.Student;
import com.bgd.sky.bean.StudentCourse;
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
            String name = user.getName();
            String password = user.getPassword();
            pstm.setString(1, name);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                flag = true;
                String sqlName = "select id from web.user where name=?";
                pstm = con.prepareStatement(sqlName);
                pstm.setString(1, name);
                ResultSet resultSet = pstm.executeQuery();
                user.setId(rs.getString(1));
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
            String sql = "insert into web.student(sid,sname,sage,sclass,spassword) values(?,?,?,?,'123')";
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
            String sql = "select sid,sname,sage,sclass from web.student";
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

    @Override
    public boolean stuFind(Student student) throws Exception {
        boolean flag = false;
        try {
            String sql = "select * from web.student where sname=? and spassword=?";
            pstm = con.prepareStatement(sql);
            String sname = student.getSname();
            String spassword = student.getSpassword();
            pstm.setString(1, sname);
            pstm.setString(2, spassword);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                flag = true;
                String sqlName = "select sid from web.student where sname=?";
                pstm = con.prepareStatement(sqlName);
                pstm.setString(1,sname);
                ResultSet resultSet = pstm.executeQuery();
                student.setSid(rs.getString(1));
                pstm.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return flag;
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

    // select course

    @Override
    public List sCouList() {
        List sCouList = null;
        try {
            String sql = "select * from web.course where cid not in (select cid from web.s_c)";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            sCouList = new ArrayList();

            while (rs.next()){
                Course course = new Course();
                course.setCid(rs.getString(1));
                course.setCname(rs.getString(2));
                course.setCinr(rs.getString(3));
                course.setCredit(rs.getString(4));
                sCouList.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sCouList;
    }

    @Override
    public List rSCouList() {
        List rSCouList = null;
        try {
            String sql = "select * from web.course where cid  in (select cid from web.s_c)";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rSCouList = new ArrayList();

            while (rs.next()){
                Course course = new Course();
                course.setCid(rs.getString(1));
                course.setCname(rs.getString(2));
                course.setCinr(rs.getString(3));
                course.setCredit(rs.getString(4));
                rSCouList.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rSCouList;
    }

    @Override
    public boolean selectCou(Student student, Course course) throws Exception {
        boolean flag = false;
        try {
            String sql = "insert into web.s_c(sid, cid) values(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, student.getSid());
            pstm.setString(2, course.getCid());
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
    public List studentCouList() {
        List studentCouList = null;
        try {
            String sql = "select student.*,course.*  from web.s_c,web.student,web.course where s_c.sid=student.sid and s_c.cid=course.cid; ";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            studentCouList = new ArrayList();

            while (rs.next()){
                Student student = new Student();
                Course course = new Course();
                student.setSid(rs.getString(1));
                student.setSname(rs.getString(2));
                student.setSage(rs.getString(3));
                student.setSclass(rs.getString(4));
                student.setSpassword(rs.getString(5));
                course.setCid(rs.getString(6));
                course.setCname(rs.getString(7));
                course.setCinr(rs.getString(8));
                course.setCredit(rs.getString(9));
                studentCouList.add(student);
                studentCouList.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentCouList;
    }

    @Override
    public boolean delSelectCou(StudentCourse studentCourse) throws Exception {
        boolean flag = false;
        try {
            String sql = "delete from web.s_c where cid=? and sid=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, studentCourse.getCid());
            pstm.setString(2, studentCourse.getSid());
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
}
