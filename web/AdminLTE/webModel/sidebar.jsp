<%--
  Created by IntelliJ IDEA.
  User: weihaolee
  Date: 2019/11/27
  Time: 9:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="logicName.jsp"%>
<html>




    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="dist/img/defaultUser.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p class="username">

                    <%
                        out.println(username);
                    %>

                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单</li>
            <li class="treeview" onclick="javascript:menuOpen()">
                <a>
                    <i class="fa fa-star-half-full"></i>
                    <span>学生信息</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="searchStudent.jsp"><i class="fa fa-circle-o"></i> 查询学生信息</a></li>
                    <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 添加</a></li>
                    <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> 修改</a></li>
                    <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> 删除</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->

<script>
    function menuOpen(){
        $(document).on("click",".sidebar-menu li a",function (e) {
            var firstParent=$(this).parent("li");
            var firstChildUl=$(this).next("ul");
            if(firstParent.hasClass("menu-open")){
                firstParent.removeClass("menu-open");
                firstChildUl.hide();
            }else{
                firstParent.addClass("menu-open");
                firstChildUl.show();
            }
        });
    }
</script>


</html>
