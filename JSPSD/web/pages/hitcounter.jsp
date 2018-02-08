<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/8/18
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--Any thing declared here will be in the serlvet class as the instance--%>
    <%!
        private Integer count = 0;
    %>
    <h1>Welcome to Public Global Hit Counter</h1>
    <h2>Your Public ID is <%= count++ %>
</body>
</html>
