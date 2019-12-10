package com.bgd.sky.servlet;

import com.bgd.sky.bean.Course;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addCou extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String cinr = request.getParameter("cinr");
        String credit = request.getParameter("credit");

        Course course = new Course();
        course.setCid(cid);
        course.setCname(cname);
        course.setCinr(cinr);
        course.setCredit(credit);

        try {
            if (DAOFactory.getUserDAOInstance().addCou(course)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表
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
