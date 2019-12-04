<%--
  Created by IntelliJ IDEA.
  User: weihaolee
  Date: 2019/12/3
  Time: 8:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="bower_components/morris.js/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="dist/css/modules/layer/default/layer.css">

</head>
<body>

<div class="box">
    <div class="box-header">
        <h3 class="box-title">修改学生信息</h3>
    </div>
    <form class="form-horizontal" action="../updateStu">
        <div class="box-body">
            <div class="form-group">
                <label for="sid" class="col-sm-2 control-label">学籍号</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" id="sid"  name="sid" value="<%=request.getParameter("sid")%>">
                </div>
            </div>
            <div class="form-group">
                <label for="sname" class="col-sm-2 control-label">姓名</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="sname"  name="sname" value="<%=request.getParameter("sname")%>">
                </div>
            </div>
            <div class="form-group">
                <label for="sage" class="col-sm-2 control-label">年龄</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" id="sage"  name="sage" value="<%=request.getParameter("sage")%>">
                </div>
            </div>
            <div class="form-group">
                <label for="sclass" class="col-sm-2 control-label">班级</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" id="sclass"  name="sclass" value="<%=request.getParameter("sclass")%>">
                </div>
            </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <button type="submit" class="btn btn-info pull-right">修改</button>
        </div>
        <!-- /.box-footer -->
    </form>
</div>
<script src="dist/js/layui.js"></script>
<script src="dist/js/lay/modules/layer.js"></script>
</body>
</html>
