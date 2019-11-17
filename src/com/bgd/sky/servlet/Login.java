package com.bgd.sky.servlet;

import com.bgd.sky.bean.User;
import com.bgd.sky.foctory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password =request.getParameter("password");

        // 通过javabean
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        try {
            if (DAOFactory.getUserDAOInstance().find(user)){
                request.getRequestDispatcher("AdminLTE/index.html").forward(request, response);
            }else{
                request.getRequestDispatcher("AdminLTE/pages/examples/login.html").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
