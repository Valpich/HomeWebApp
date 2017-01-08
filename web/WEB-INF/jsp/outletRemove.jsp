<%--
  Created by IntelliJ IDEA.
  User: dev.valentinpichavant
  Date: 01/07/17
  Time: 06:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<sec:authorize access="isAuthenticated()">

    <html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Index</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>


    <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <header class="main-header">

            <!-- Logo -->
            <a href="${pageContext.request.contextPath}/" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>HC</b></span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Home Controller</b> Web</span>
            </a>

            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                </a>
                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="https://www.facebook.com">
                                <sec:authentication property="principal.socialSignInProvider" var="signInProvider"/>
                                <c:if test="${signInProvider != null}">
                                    <img src="<sec:authentication
            property="principal.profilePicture"/>" class="user-image" alt="User Image">
                                </c:if>
                                <c:if test="${signInProvider == null}">
                                    <img src="${pageContext.request.contextPath}/static/dist/img/empty_picture.png"
                                         class="user-image" alt="User Image">
                                </c:if>
                                <span class="hidden-xs"><sec:authentication
                                        property="principal.firstName"/> <sec:authentication
                                        property="principal.lastName"/></span>
                            </a>

                            <!-- Control Sidebar Toggle Button -->
                        <li>
                            <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i></a>
                        </li>
                    </ul>
                </div>

            </nav>
        </header>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <sec:authentication property="principal.socialSignInProvider" var="signInProvider"/>
                        <c:if test="${signInProvider != null}">
                            <img src="<sec:authentication
            property="principal.profilePicture"/>" class="img-circle" alt="User Image">
                        </c:if>
                        <c:if test="${signInProvider == null}">
                            <img src="${pageContext.request.contextPath}/static/dist/img/empty_picture.png"
                                 class="img-circle" alt="User Image">
                        </c:if>
                    </div>
                    <div class="pull-left info">
                        <p><sec:authentication
                                property="principal.firstName"/> <sec:authentication
                                property="principal.lastName"/></p>
                        <i class="fa fa-circle text-success"></i> Online
                    </div>
                </div>
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">MAIN NAVIGATION</li>
                    <li class="active treeview">
                        <a href="${pageContext.request.contextPath}/">
                            <i class="fa fa-home"></i> <span>Home</span>
                            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                        </a>
                        <ul class="treeview-menu">
                            <li class="active"><a href="${pageContext.request.contextPath}/outlet"><i
                                    class="fa fa-circle-o"></i> Outlets </a></li>
                        </ul>
                    </li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Home Controller
                    <small>Version 1.0</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> Home</a></li>
                    <li class="active">Outlets</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Delete an outlet</h3>
                    </div>
                    <div class="box-body">
                        <div class="btn-group">
                            <script type="text/javascript">
                                var clicked;
                                function mysubmit() {
                                    var input = document.createElement("input");
                                    input.setAttribute("type", "hidden");
                                    input.setAttribute("name", "id");
                                    input.setAttribute("value", clicked);
                                    document.getElementById("button_" + clicked).appendChild(input);
                                }
                            </script>
                            <form:form method="POST" action="${pageContext.request.contextPath}/outlet/remove"
                                       onsubmit="mysubmit();">
                                <c:forEach items="${outlets}" var="outlet">
                                    <button type="submit" id="button_<c:out value="${outlet.id}"/>" type="button"
                                            class="btn btn-block btn-warning btn-flat"
                                            onclick="clicked='<c:out value="${outlet.id}"/>'"><c:out
                                            value="${outlet.description}"/></button>
                                </c:forEach>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form:form>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 2.3.7
            </div>
            <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All
            rights
            reserved.
        </footer>
        <!-- Add the sidebar's background. This div must be placed
             immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>

    </div>
    <!-- ./wrapper -->

    <!-- jQuery 2.2.3 -->
    <script src="${pageContext.request.contextPath}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath}/static/plugins/fastclick/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/static/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/static/dist/js/demo.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/ajax/outlet.js"></script>
    </body>
    formaction=
    </html>
</sec:authorize>
