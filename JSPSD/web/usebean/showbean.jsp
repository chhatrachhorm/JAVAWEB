<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 2/20/2018
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean class="data.model.User" id="user"/>
    <jsp:setProperty name="user" property="username"/>
    <jsp:setProperty name="user" property="email"/>

    <jsp:getProperty name="user" property="username"/><br>
    <jsp:getProperty name="user" property="email"/>
</body>
</html>
