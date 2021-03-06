<%@ page import="java.util.List" %>
<%@ page import="com.bgd.sky.foctory.DAOFactory" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.bgd.sky.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="webModel/logicName.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LeeIn | 个人资料</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
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
    <link rel="stylesheet" href="dist/css/modules/layer/default/layer.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue-light sidebar-mini sidebar-collapse">
<div class="wrapper">

    <header class="webHeader">

    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <%--profile--%>
                    <div class="box ">
                        <div class="box-body box-profile">
                            <img class="profile-user-img img-responsive img-circle" src="dist/img/defaultUser.png" alt="User profile picture">

                            <h3 class="profile-username text-center"><%out.println(username);%></h3>

                            <p class="text-muted text-center"><%out.println(userType);%></p>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>ID号</b> <a class="pull-right"><%out.println(userId);%></a>
                                </li>
                                <li class="list-group-item">
                                    <b>用户名</b> <a class="pull-right"><%out.println(username);%></a>
                                </li>
                                <li class="list-group-item">
                                    <b>用户类型</b> <a class="pull-right"><%out.println(userType);%></a>
                                </li>
                            </ul>

                            <a href="../desSession" class="btn btn-primary btn-block btn-danger"><b>登出</b></a>
                        </div>
                        <!-- /.box-body -->
                    </div>
                        <!-- Post -->
                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">个人相册</h3>
                            </div>
                        <div class="post">
                            <div class="row margin">
                                <div class="col-sm-6">
                                    <img class="img-responsive" src="dist/img/photo1.png" alt="Photo">
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-6">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <img class="img-responsive" src="dist/img/photo2.png" alt="Photo">
                                            <br>
                                            <img class="img-responsive" src="dist/img/photo3.jpg" alt="Photo">
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-6">
                                            <img class="img-responsive" src="dist/img/photo2.png" alt="Photo">
                                            <br>
                                            <img class="img-responsive" src="dist/img/photo1.png" alt="Photo">
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>
                            <div class="box-footer">

                            </div>
                        </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.row (main row) -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="webFooter">
    </footer>


    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable()
        $('#example2').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : false
        })
    })
</script>

<script src="bower_components/raphael/raphael.min.js"></script>
<script src="bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="bower_components/moment/min/moment.min.js"></script>
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script src="dist/js/layui.js"></script>
<script src="dist/js/lay/modules/layer.js"></script>
<script>
    function x_admin_show(title,url,w,h){
        if (title == null || title == '') {
            title=false;
        };
        if (w == null || w == '') {
            w=800;
        };
        if (h == null || h == '') {
            h=($(window).height() - 50);
        };
        layer.open({
            type: 2,
            area: [w+'px', h +'px'],
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade:0.4,
            title: title,
            content: url
        });
    }
</script>
<script>
    function member_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }
</script>

<script type="text/javascript">

    $('.webHeader').load('webModel/header.jsp');
    $('.main-sidebar').load('webModel/sidebar.jsp');
    $('.webFooter').load('webModel/footer.jsp');
</script>

<script type="text/javascript">
    function base64 (content) {
        return window.btoa(unescape(encodeURIComponent(content)));
    }
    /*
    *@tableId: table的Id
    *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
    */
    function tableToExcel(tableID,fileName){
        var table = document.getElementById(tableID);
        var excelContent = table.innerHTML;
        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
        excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
        excelFile += "<body><table>";
        excelFile += excelContent;
        excelFile += "</table></body>";
        excelFile += "</html>";
        var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
        var a = document.createElement("a");
        a.download = fileName+".xls";
        a.href = link;
        a.click();
    }
</script>

</body>
</html>
