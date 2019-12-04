package com.bgd.sky.servlet;

import com.bgd.sky.bean.Student;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delStu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        Student student = new Student();
        student.setSid(sid);
        try {
            if (DAOFactory.getUserDAOInstance().delStu(student)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表
                response.sendRedirect("AdminLTE/searchStudent.jsp");
//                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
            }else{
                response.sendRedirect("AdminLTE/searchStudent.jsp");
//                request.getRequestDispatcher("AdminLTE/pages/examples/login.html").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
