package com.bgd.sky.servlet.method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载驱动
            String url = "jdbc:mysql://localhost:3306/web";
            Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
            String sql = "select * from user where name= ? and password= ?";
            PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
            pstm.setString(1, userName); // 设置参数
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery(); //数据库查询操作
            if(rs.next()){
                PrintWriter out = response.getWriter();
                out.println("登陆成功");
                response.sendRedirect("AdminLTE/pages/examples/main.html");
            }else{
                response.setCharacterEncoding("GBK");
                PrintWriter out = response.getWriter();
                out.println("登陆失败");
            }
            pstm.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
