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
    <title>Add</title>
</head>
<body>
    <div>
        <h1>Add A New Book</h1>
        <form action="${pageContext.request.contextPath}/global-controller" method="post">
            <label>Book SSN: <input type="text" name="ssn"></label><br>
            <label>Book Title: <input type="text" name="title"></label><br>
            <label>Book Author: <input type="text" name="author"></label><br>
            <label>Publish Year: <input type="number" name="year"></label><br>
            <input type="hidden" name="operation" value="add">
            <input type="submit">
        </form>
    </div>
</body>
</html>
