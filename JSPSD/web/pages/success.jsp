<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/7/18
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h1>Welcome Home <%= session.getAttribute("username") %></h1>
    <div>
        <a href="hitcounter.jsp"> Click Here to Go to Global Counter </a>
        <a href="usersessionid.jsp">Click Here to Go to Your Session ID Counter</a>
    </div>
    <a href="destroy.jsp"><button>Log Out</button></a>
</body>
</html>
