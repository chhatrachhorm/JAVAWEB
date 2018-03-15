<%@ page import="model.Student" %><%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/15/2018
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <%
        Student s = (Student) session.getAttribute("student");
    %>
    <h1>Welcome Home <%= s.getName() %></h1>
</body>
</html>
