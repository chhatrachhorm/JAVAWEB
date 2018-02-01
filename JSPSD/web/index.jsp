<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/1/18
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP</title>
  </head>
  <body>
    <main>
        <div>
            <h1>Validate with JSP</h1>
            <form action="pages/validate.jsp" method="post">
                <label>Name: <input type="text" name="username"></label><br>
                <label>Password: <input type="password" name="password"></label><br>
                <button type="submit">Log in</button>
            </form>
        </div>
    </main>
  </body>
</html>
