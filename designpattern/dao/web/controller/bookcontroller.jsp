<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/16/2018
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String options = request.getParameter("book-option");
    System.out.println("Options is " + options);
    switch (options){
        case "add":
            response.sendRedirect("/pages/add.jsp");
            break;
        case "delete":
            response.sendRedirect("/pages/delete.jsp");
            break;
        case "shows":
            response.sendRedirect("/pages/shows.jsp");
            break;
        case "update":
            response.sendRedirect("/pages/update.jsp");
            break;
    }
%>
