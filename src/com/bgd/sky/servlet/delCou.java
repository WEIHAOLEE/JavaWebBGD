package com.bgd.sky.servlet;

import com.bgd.sky.bean.Course;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delCou extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        Course course = new Course();
        course.setCid(cid);
        try {
            if (DAOFactory.getUserDAOInstance().delCou(course)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表
                response.sendRedirect("AdminLTE/searchCourse.jsp");
//                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
            }else{
                response.sendRedirect("AdminLTE/searchCourse.jsp");
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
