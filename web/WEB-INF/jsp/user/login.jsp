<%--
  Created by IntelliJ IDEA.
  User: valentinpichavant
  Date: 10/21/16
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">

<!--
    If the user is anonymous (not logged in), show the login form
    and social sign in buttons.
-->
<sec:authorize access="isAnonymous()">
    <c:if test="${param.error eq 'bad_credentials'}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <spring:message code="text.login.page.login.failed.error"/>
        </div>
    </c:if>

    <div class="login-box">
        <div class="login-logo">
            <b>Home controller</b><br/>Web Application</a>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <p class="login-box-msg">Sign in to start your session</p>

            <form action="${pageContext.request.contextPath}/login/authenticate" method="post">
                <div class="form-group has-feedback">
                    <input type="email" id="user-email" name="username" class="form-control" placeholder="Email">
                </div>
                <div class="form-group has-feedback">
                    <input type="password" id="user-password" name="password" class="form-control"
                           placeholder="Password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <div class="form-group">
                <button onclick="window.location.href='${pageContext.request.contextPath}/user/register'"
                        class="btn btn-warning btn-block btn-flat">Sign Up
                </button>
            </div>
            <div class="social-auth-links text-center">
                <p>- OR -</p>
                <a href="${pageContext.request.contextPath}/auth/facebook"
                   class="btn btn-block btn-social btn-facebook btn-flat" style="text-align: center;"><i
                        class="fa fa-facebook"></i><spring:message
                        code="label.facebook.sign.in.button"/></a>
        </div>
            <!-- /.social-auth-links -->

    </div>
        <!-- /.login-box-body -->
    </div>
    <!-- /.login-box -->

    <!-- jQuery 2.2.3 -->
    <script src="${pageContext.request.contextPath}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/static/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(function () {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });
    </script>
</sec:authorize>
<!--
    If the user is already authenticated, show a help message instead
    of the login form and social sign in buttons.
-->
<sec:authorize access="isAuthenticated()">
    <p><spring:message code="text.login.page.authenticated.user.help"/></p>
</sec:authorize>
</body>
</html>