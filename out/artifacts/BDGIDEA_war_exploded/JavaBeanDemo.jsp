<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bgd.sky.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	User user=new User();

	user.setId(10);
	user.setName("bean");
	user.setPassword("123");
%>
<%= user.getId() %>
<%= user.getName() %>
<%= user.getPassword() %>
</body>
</html>