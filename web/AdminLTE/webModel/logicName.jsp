<%--
  Created by IntelliJ IDEA.
  User: weihaolee
  Date: 2019/12/6
  Time: 9:07 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) request.getSession().getAttribute("username");
    String userType = (String) request.getSession().getAttribute("userType");
    String userId = (String) request.getSession().getAttribute("userId");
    String userList = "                <ul class=\"treeview-menu\">\n" +
            "                    <li><a href=\"searchStudent.jsp\"><i class=\"fa fa-circle-o\"></i> 学生信息</a></li>\n" +
            "                    <li><a href=\"searchCourse.jsp\"><i class=\"fa fa-circle-o\"></i> 课程信息</a></li>\n" +
            "                    <li><a href=\"profile.jsp\"><i class=\"fa fa-circle-o\"></i> 用户信息</a></li>\n" +
            "                    <li><a href=\"studentCourse.jsp\"><i class=\"fa fa-circle-o\"></i> 学生选课概况</a></li>\n" +
            "                </ul>";
    String studentList = "                <ul class=\"treeview-menu\">\n" +
            "                    <li><a href=\"selectCourse.jsp\"><i class=\"fa fa-circle-o\"></i> 选课信息</a></li>\n" +
            "                    <li><a href=\"profile.jsp\"><i class=\"fa fa-circle-o\"></i> 用户信息</a></li>\n" +
            "                </ul>";
    if (username == null){
        response.sendRedirect("pages/examples/login.html");
    }
%>