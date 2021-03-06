package com.bgd.sky.servlet;

import com.bgd.sky.bean.Student;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateStu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String sclass = request.getParameter("sclass");
        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);
        student.setSage(sage);
        student.setSclass(sclass);

        try {
            if (DAOFactory.getUserDAOInstance().updateStu(student)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表

                PrintWriter out = response.getWriter();
                out.print("<script>parent.location.reload();</script>"); //关闭iframe字页面并刷新父页面 重新加载整个页面
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
