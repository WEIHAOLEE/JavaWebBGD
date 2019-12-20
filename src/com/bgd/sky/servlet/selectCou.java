package com.bgd.sky.servlet;

import com.bgd.sky.bean.Course;
import com.bgd.sky.bean.Student;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class selectCou extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = (String) request.getSession().getAttribute("userId");
        String[] cid = request.getParameterValues("getCid");

        Student student = new Student();

        student.setSid(sid);


        for (int i=0; i < cid.length; i++){
            Course course = new Course();
            course.setCid(cid[i]);
            try {
                if (DAOFactory.getUserDAOInstance().selectCou(student,course)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表
                    response.sendRedirect("AdminLTE/selectCourse.jsp");
//                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
                }else{
                    response.sendRedirect("AdminLTE/selectCourse.jsp");
//                request.getRequestDispatcher("AdminLTE/pages/examples/login.html").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
