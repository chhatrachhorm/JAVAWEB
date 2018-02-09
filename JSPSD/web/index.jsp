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
    <%
        if(!session.isNew()){
            if(session.getAttribute("uid") == null){
                session.invalidate();
                session.setMaxInactiveInterval(0);
                response.sendRedirect("/");
            }else response.sendRedirect("/pages/success.jsp");
        }
    %>
    <main>
        <div>
            <h1>Login with JSP</h1>
            <form action="pages/validate.jsp" method="post">
                <label>Name: <input type="text" name="username"></label><br>
                <label>Password: <input type="password" name="password"></label><br>
                <button type="submit">Log in</button>
            </form>
        </div>
        <div>
            <h2>Has no account?</h2>
            <h3>Sign Up Now for Free</h3>
            <form action="signup/validate.jsp" method="post">
                <label>Username: <input type="text" name="username"></label><br>
                <label>Password: <input type="password" name="password"></label><br>
                <label>Confirm Password: <input type="password" name="confirm_pass"></label><br>
                <label>Phone Number: <input type="tel" name="phone"></label><br>
                <label>Email: <input type="email" name="email"></label><br>
                <label>Date of Birth: <input type="date" name="dob"></label><br>
                <button type="submit">Sign Up</button>
            </form>
        </div>
    </main>
  </body>
</html>
