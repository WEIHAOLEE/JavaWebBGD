package com.bgd.sky.servlet;

import com.bgd.sky.bean.Student;
import com.bgd.sky.bean.User;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password =request.getParameter("password");
        String userType = request.getParameter("userType");
        System.out.println(userType);

        if (userType.equals("user")){
            // 通过javabean
            User user = new User();
            user.setName(username);
            user.setPassword(password);


            try {
                if (DAOFactory.getUserDAOInstance().find(user)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表

                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("userType", "超级管理员");
                    request.getSession().setAttribute("userId",user.getId());


                    response.sendRedirect("AdminLTE/index.jsp");

//                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
                }else{
                    response.sendRedirect("AdminLTE/pages/examples/login.html");
//                request.getRequestDispatcher("AdminLTE/pages/examples/login.html").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(userType.equals("student")){
            Student student = new Student();
            student.setSname(username);
            student.setSpassword(password);

            try {
                if (DAOFactory.getUserDAOInstance().stuFind(student)){  //用dao工厂模式下 getuserdaoinstance这个方法访问到user这个表

                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("userType", "学生");
                    request.getSession().setAttribute("userId",student.getSid());


                    response.sendRedirect("AdminLTE/index.jsp");

//                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
                }else{
                    response.sendRedirect("AdminLTE/pages/examples/login.html");
//                request.getRequestDispatcher("AdminLTE/pages/examples/login.html").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        String ajaxName = (String) request.getSession().getAttribute("name");
//        out.write(ajaxName);
//        out.flush();
//        out.close();
    }
}
