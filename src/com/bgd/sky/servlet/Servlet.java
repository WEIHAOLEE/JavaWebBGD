package com.bgd.sky.servlet;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("从form表单获取的内容是：Id: " + id + "用户名：" + username + "密码：" + password + "\n");
        PrintWriter out = response.getWriter();
        out.println("从form表单获取的内容是：Id: " + id + "用户名：" + username + "密码：" + password);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
