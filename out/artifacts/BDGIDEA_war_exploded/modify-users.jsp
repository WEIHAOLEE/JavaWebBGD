<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
	String userName = request.getParameter("userName");
	if("".equals(userName)){
		out.println("用户不存在");
	}else{
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			String url = "jdbc:mysql://localhost:3306/web?useunicode=true&characterencoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "root", "12345678");  //建立链接
			String sql = "select * from user where id=?"; //删除
			PreparedStatement pstm = con.prepareStatement(sql); //创建语句对象
			pstm.setString(1,userName);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
%>
				<form action="modify-do.jsp" method="post">
					id:<input  type="text" name="id" value=<%=rs.getString(1)%> /><br/>
					name:<input type="text" name="userName" value=<%=rs.getString(2)%> /><br/>
					password:<input type="text" name="password" value=<%=rs.getString(3)%> /><br/>
					<input type="submit" value="修改"/>				
				</form>



<%				
				
			}
			rs.close();
			pstm.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}



%>
</body>
</html>