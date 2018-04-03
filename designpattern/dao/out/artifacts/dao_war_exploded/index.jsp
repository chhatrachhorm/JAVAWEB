<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/16/2018
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Book Registration</title>
  </head>
  <body>
    <div>
      <h1>Please Select Your Option</h1>
      <form action="controller/bookcontroller.jsp" method="post">
        <label>Select Your Options:
          <select name="book-option">
            <option value="add">Add a New Book</option>
            <option value="delete">Delete A Book</option>
            <option value="update">Update A Particular Book</option>
            <option value="shows">Show The Book</option>
          </select>
        </label>
        <input type="submit">
      </form>
    </div>
  </body>
</html>
