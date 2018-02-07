<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/1/18
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String username = request.getParameter("username");
    String pass = request.getParameter("password");
    if (username.equals("chhatrachhorm") && pass.equals("123")) {
        out.print("Hello, Welcome Home!");
        HttpSession login_session = request.getSession();
        login_session.setAttribute("uid", username + pass);
        login_session.setAttribute("username", username);
        response.sendRedirect("/pages/success.jsp");
    } else out.print("Access Denied");
%>

