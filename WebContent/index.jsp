<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			String url = "jdbc:mysql://localhost:3306/web";
			Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
			String sql = "insert into user(name,password) values(?,?)"; //id自增 三个数值 需要明确写出哪两个
			PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
			pstm.setString(1, userName); // 设置参数
			pstm.setString(2, password);
			pstm.executeUpdate();//更新
			response.sendRedirect("AdminLTE/pages/examples/login.html");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	%>
	

</body>
</html>