<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/7/18
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Destroy</title>
</head>
<body>
    <%
        HttpSession login_session = request.getSession();
        login_session.invalidate();
        login_session.setMaxInactiveInterval(0);
        response.sendRedirect("/");
    %>
    <h1>Logging You Out</h1>
</body>
</html>
