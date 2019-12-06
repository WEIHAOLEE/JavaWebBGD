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
    if (username == null){
        response.sendRedirect("pages/examples/login.html");
    }
%>