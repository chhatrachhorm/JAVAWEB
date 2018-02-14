<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/9/18
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Array Result</title>
</head>
<body>
<%
    Integer size = Integer.valueOf(request.getParameter("arraySize").trim());
    Integer[] array = new Integer[size];
    String arr = request.getParameter("arrayElements").trim();
    String[] elements = arr.split(",");
    Integer i = 0;
    for(String e: elements){
        array[i] = Integer.valueOf(e);
        i++;
    }
%>
<h3>The Array is </h3>
<table>
<% for (int j = 0; j < array.length; j++) {%>
    <tr>
        <td><%= j+1 %></td><td><%= array[j]%></td>
    </tr>
<%}%>
</table>
</body>
</html>
