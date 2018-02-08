<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/8/18
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Integer session_counter = (Integer) session.getAttribute("counter");
        if (session.getAttribute("uid") == null){
            response.sendRedirect("/");
        }else if(session_counter == null || session_counter == 0){
            session_counter = 1;
        } else {
            session_counter++;
        }
        session.setAttribute("counter", session_counter);
    %>
    <h1>Hi <%= session.getAttribute("username")%>, Welcome to Session Counter</h1>
    <h3>Your Session for this Browser is <%= session_counter %></h3>
</body>
</html>
