<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.bgd.sky.User" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<% 


%>
<%= user.getId() %>
<%= user.getName() %>
<%= user.getPassword() %>