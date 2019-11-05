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
	<%
	String id = request.getParameter("id");
	int i = Integer.parseInt(id);
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			String url = "jdbc:mysql://localhost:3306/web?useunicode=true&characterencoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
			String sql = "update user set name=?,password=? where id=?"; //删除
			PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
			pstm.setString(1,userName);
			pstm.setString(2,password);
			pstm.setInt(3,i);
			pstm.executeUpdate();
			pstm.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
<jsp:forward page="userList.jsp"></jsp:forward>
</body>
</html>
</body>
</html>