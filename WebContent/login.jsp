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
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		String url = "jdbc:mysql://localhost:3306/web";
		Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
		String sql = "select * from user where name= ? and password= ?";
		PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
		pstm.setString(1, userName); // 设置参数
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery(); //数据库查询操作
		if(rs.next()){
			out.println("登陆成功");
		}else{
			out.println("登陆失败");
		}
		pstm.close();
		con.close();
	%>

</body>
</html>