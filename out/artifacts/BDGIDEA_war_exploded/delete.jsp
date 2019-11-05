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
		<form action="delete.jsp" method="post">
        	<input type="text" name ="userName"/><br/>
        	<input type="submit" value="提交"/>
        </form>
	<%
	String userName = request.getParameter("userName");
	if("".equals(userName)){
		out.println("用户不存在");
	}else{
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			String url = "jdbc:mysql://localhost:3306/web";
			Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
			String sql = "delete from user where id=?"; //删除
			PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
			pstm.setString(1,userName);
			pstm.executeUpdate();
			pstm.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	%>
</body>
</html>
</body>
</html>