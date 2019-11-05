<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body>

	请输入查询关键字：
	<form action="userList.jsp" method="post">
		<input type="text" name="keyword"/>
		<input type="submit" value="查询"/>
	
	
	</form>
	
	
	
	<%
	
	
	
		
		
		
		
	try{
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		String url = "jdbc:mysql://localhost:3306/web";
		Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
		String keyword = request.getParameter("keyword");
		String sql ="";
		PreparedStatement pstm;
		if("".equals(keyword)){
			sql = "select * from user"; //查询全部数据
			pstm = con.prepareStatement(sql); 
		}else{
			sql = "select * from user where name like '%" + keyword + "%'"; //查询单独一个数据
			pstm = con.prepareStatement(sql); //创建语句对象
		}
		
		
		ResultSet rs = pstm.executeQuery();
		out.println("<table border='1'>");
		
		out.println("<td>");
		out.println("用户编号");
		out.println("</td>");
		out.println("<td>");
		out.println("用户名");
		out.println("</td>");
		out.println("<td>");
		out.println("密码");
		out.println("</td>");
		out.println("<td colspan='2'>");
		out.println("操作");
		out.println("</td>");
		
		while(rs.next()){
			String i = rs.getString(1);
			out.println("<tr>");
			out.println("<td>");
			out.println(i);
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString(2));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString(3));
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='modify-users.jsp?userName="+ i + "'>编辑</a>");
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='delete.jsp'>删除</a>");
			out.println("</td>");
			out.println("<tr>");

		}
		out.println("</table>");
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
</body>
</html>