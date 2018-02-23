<%@ page import="java.util.Map" %>
<%@ page import="model.helper.JWTHelper" %><%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/1/18
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <%@include file="asset/subpages/header.jsp"%>
  <body>
  <%
      System.out.println("Gone throw login filter");
      String jwt = (String) session.getAttribute("jwtID");
      if(session.getAttribute("jwtID") != null){
          Map<String, Object> results = JWTHelper.validateToken(jwt);
          System.out.println("JWT Result: " + results);
          System.out.println("JWT TOKEN: " + results);
          if(results.get("error") != null){
              session.setAttribute("jwtID", null);
          }else{
              response.sendRedirect("/pages/success.jsp");
          }
      }else{
          System.out.println("JWT NULL");
      }

  %>
      <div class="container">
          <div>
                  <h1>Login with JSP</h1>
                  <form action="loginUser" method="post">
                      <label>Name: <input type="text" name="identifier"></label><br>
                      <label>Password: <input type="password" name="password"></label><br>
                      <%
                          if(session.getAttribute("login-error") != null){ %>
                      <strong style="color: red">
                          <%= session.getAttribute("login-error")%>
                      </strong><br>
                      <%
                          }
                      %>
                      <button type="submit">Log in</button>
                  </form>
              </div>
          <div>
                  <h2>Has no account?</h2>
                  <h3>Sign Up Now for Free</h3>
                  <form action="registerUser" method="post">
                      <label>Username: <input type="text" name="username"></label><br>
                      <label>Password: <input type="password" name="password"></label><br>
                      <label>Confirm Password: <input type="password" name="confirm_pass"></label><br>
                      <label>Phone Number: <input type="tel" name="phone"></label><br>
                      <label>Email: <input type="email" name="email"></label><br>
                      <label>Date of Birth: <input type="date" name="dob"></label><br>
                      <%
                          if(session.getAttribute("sign-up-error") != null){ %>
                      <strong style="color: red">
                          <%= session.getAttribute("sign-up-error")%>
                      </strong><br>
                      <%
                          }
                      %>
                      <button type="submit">Sign Up</button>
                  </form>
              </div>
      </div>
  </body>
</html>
