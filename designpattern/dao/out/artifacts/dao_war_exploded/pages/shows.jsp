<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/16/2018
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shows</title>
</head>
<body>
<div>
    <h1>Search A Book</h1>
    <form action="${pageContext.request.contextPath}/global-controller" method="post">
        <label>Book Title: <input type="text" name="title"></label><br>
        <input type="hidden" name="operation" value="shows">
        <input type="submit">
    </form>
</div>
</body>
</html>
