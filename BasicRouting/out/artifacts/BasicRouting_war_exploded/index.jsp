<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 11/22/2017
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <h1>Login to Validate Cookie</h1>
    <form action="login-cookie" method="post">
      <label>Username: <input type="text" name="username"></label><br>
      <label>Password: <input type="password" name="password"></label>
      <button type="submit">
        Submit
      </button>
    </form>
  </div>
  <div>
      <h1>Login to Validate Session</h1>
      <form action="login-session" method="post">
          <label>Username: <input type="text" name="username"></label><br>
          <label>Password: <input type="password" name="password"></label>
          <button type="submit">
              Submit
          </button>
      </form>
  </div>
  <div>
    <a href="login-controller">Click Here to Login with Validation</a>
  </div>
  <div>
      <h1>You Have to Go Through a Filter in order to see the success page</h1>
      <form action="param-filter" method="post">
          <label>Username: <input type="text" name="username"></label><br>
          <label>Password: <input type="password" name="password"></label>
          <button type="submit">Go for Filter</button>
      </form>
  </div>

  <div>
    <a href="request-counting">Click here to get your UserID</a>    
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  </body>
</html>
