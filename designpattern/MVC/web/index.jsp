<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/15/2018
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <div>
      <h1>Enter Your Student Info</h1>
      <form action="register" method="post">
        <label>Name: <input type="text" name="name"></label><br>
        <label>ID: <input type="text" name="id"></label><br>
        <label>Email: <input type="email" name="email"></label><br>
        <label>Password: <input type="password" name="password"></label><br>
        <button type="submit">Submit</button>
        <%
          if(session.getAttribute("info-error") != null){ %>
        <strong style="color: red">
          <%= session.getAttribute("info-error")%>
        </strong><br>
        <%
          }
        %>
      </form>
    </div>
  </body>
</html>
