<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/9/18
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%--Enable Error Page to True to Make this Page as the default Error Page--%>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Opp! Exception Occurred</h1>
    <h3>Only Bad Programmer writes code that makes Exception Occurs</h3>
    <p style="color: red">
        <%= exception %>
    </p>
</body>
</html>
