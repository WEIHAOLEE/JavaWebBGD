<%@ page import="java.util.List" %>
<%@ page import="com.bgd.sky.foctory.DAOFactory" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.bgd.sky.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: weihaolee
  Date: 2019/11/19
  Time: 8:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
<%
    try {
        List list = DAOFactory.getUserDAOInstance().list(); //查询数据表user信息
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            User user = (User)iter.next();
%>
            <tr>
                <td><%=user.getName()%></td>
                <td><%=user.getPassword()%></td>
            </tr>


<%
}
    }catch (Exception e){
        e.printStackTrace();
    }


%>
</table>

</body>
</html>
