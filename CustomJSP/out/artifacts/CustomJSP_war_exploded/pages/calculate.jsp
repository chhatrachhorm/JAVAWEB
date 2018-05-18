<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/28/2018
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://localhost:8080/tlds/customTag" prefix="show"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <show:show num='${requestScope.num}'/>
</body>
</html>
