<%--
  Created by IntelliJ IDEA.
  User: dev.valentinpichavant
  Date: 10/17/16
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Index page</title>
</head>
<body>
This is the index.
<br/>
<sec:authorize access="isAuthenticated()">

    <span class="message">Welcome <sec:authentication property="principal.firstName"/> <sec:authentication
            property="principal.lastName"/></span>
</sec:authorize>
</body>
</html>
