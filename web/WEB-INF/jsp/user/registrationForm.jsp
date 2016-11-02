<%--
  Created by IntelliJ IDEA.
  User: valentinpichavant
  Date: 10/21/16
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Create an account</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/app/user.form.js"></script>
</head>
<body class="hold-transition login-page">

<!--
    If the user is anonymous (not logged in), show the registration form.
-->
<sec:authorize access="isAnonymous()">
    <div class="login-box">
        <div class="login-logo">
            Register here
        </div>
        <div class="login-box-body">
            <!--
                Ensure that when the form is submitted, a POST request is send to url
                '/user/register'.
            -->
            <form:form action="${pageContext.request.contextPath}/user/register" commandName="user" method="POST"
                       enctype="utf8" role="form">
                <!-- Add CSRF token to the request. -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <!--
                If the user is using social sign in, add the signInProvider
                as a hidden field.
                -->
                <c:if test="${user.signInProvider != null}">
                    <form:hidden path="signInProvider"/>
                </c:if>
                <div id="form-group-firstName" class="form-group has-feedback">
                        <label class="control-label" for="user-firstName"><spring:message
                                code="label.user.firstName"/>:</label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:hidden id="user-profilePicture" path="profilePicture" cssClass="form-control"/>

                        <form:input id="user-firstName" path="firstName" cssClass="form-control"/>
                        <form:errors id="error-firstName" path="firstName" cssClass="help-block"/>
                    </div>
                <div id="form-group-lastName" class="form-group has-feedback">
                        <label class="control-label" for="user-lastName"><spring:message
                                code="label.user.lastName"/>:</label>
                        <!--
                            Add the lastName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:input id="user-lastName" path="lastName" cssClass="form-control"/>
                        <form:errors id="error-lastName" path="lastName" cssClass="help-block"/>
                    </div>
                <div id="form-group-email" class="form-group has-feedback">
                        <label class="control-label" for="user-email"><spring:message code="label.user.email"/>:</label>
                        <!--
                            Add the email field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:input id="user-email" path="email" cssClass="form-control"/>
                        <form:errors id="error-email" path="email" cssClass="help-block"/>
                    </div>
                <!--
                If the user is creating a normal user account, add password fields
                to the form.
                -->
                <c:if test="${user.signInProvider == null}">

                    <div id="form-group-password" class="form-group has-feedback">
                            <label class="control-label" for="user-password"><spring:message
                                    code="label.user.password"/>:</label>
                            <!--
                                Add the password field to the form and ensure
                                that validation errors are shown.
                            -->
                            <form:password id="user-password" path="password" cssClass="form-control"/>
                            <form:errors id="error-password" path="password" cssClass="help-block"/>
                        </div>
                    <div id="form-group-passwordVerification" class="form-group has-feedback">
                            <label class="control-label" for="user-passwordVerification"><spring:message
                                    code="label.user.passwordVerification"/>:</label>
                            <!--
                                Add the passwordVerification field to the form and ensure
                                that validation errors are shown.
                            -->
                            <form:password id="user-passwordVerification" path="passwordVerification"
                                           cssClass="form-control"/>
                            <form:errors id="error-passwordVerification" path="passwordVerification"
                                         cssClass="help-block"/>
                        </div>
                </c:if>
                <div class="form-group">
                <!-- Add the submit button to the form. -->
                    <button type="submit" class="btn btn-warning btn-block btn-flat"><spring:message
                        code="label.user.registration.submit.button"/></button>
                </div>
            </form:form>
        </div>
    </div>
</sec:authorize>
<!--
    If the user is authenticated, show a help message instead
    of registration form.
-->
<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
<sec:authorize access="isAuthenticated()">
    <p><spring:message code="text.registration.page.authenticated.user.help"/></p>
</sec:authorize>
</body>
</html>