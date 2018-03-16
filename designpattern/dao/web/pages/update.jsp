<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/16/2018
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <h1>Update A Book Title</h1>
    <form action="${pageContext.request.contextPath}/global-controller" method="post">
        <label>Book SSN: <input type="text" name="ssn"></label><br>
        <label>New Book Title: <input type="text" name="title"></label><br>
        <input type="hidden" name="operation" value="update-title">
        <input type="submit">
    </form>
</div>
</body>
</html>
