<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/1/18
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! private String user; private String password; %>
<%
    user = request.getParameter("username");
    password = request.getParameter("password");
%>
<%
    if (user.equals("chhatrachhorm") && password.equals("123"))
    out.print("Hello, Welcome Home!");
    else out.print("Access Denied");
%>

