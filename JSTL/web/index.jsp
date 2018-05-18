<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 3/29/2018
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
  <head>
    <title>Built-in JSTL</title>
  </head>
  <body>
    <%--For Each--%>
    <c:forEach var="i" begin="1" end="5">
      <c:out value="${i}"/>
    </c:forEach>

    <%--For Tokens--%>
    <c:forTokens items="I,miss,you" delims="," var="feeling">
      <c:out value="${feeling}"/>
    </c:forTokens>

    <%--Old way of embbeding other's webpage--%>
    <c:import url="https://i-out.io"/>

    <%--For database--%>
    <s:setDataSource
            var="db"
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3308/jspsd"
            user="jspsd"
            password="R*twinklestar15+"
    />

    <%
      ArrayList<User> new_users = new ArrayList<>();
      for(int i = 0; i<5; i++) {
        // add dump data to list
        User user = new User();
        user.setUsername(user.generateSalt(6, false));
        user.setPassword(user.generateSalt(6, false));
        user.setPhoneNumber(user.generateSalt(6, true));
        user.setEmail(user.generateSalt(5, false) + "@" + user.generateSalt(3, false) + "." + user.generateSalt(2, false));
        user.setDob("1998-12-29");
        new_users.add(user);
      }
      pageContext.setAttribute("new_users", new_users);
    %>
    <%--update query to update/delete/insert--%>
    <c:forEach items="${new_users}" var="user">
      <s:update dataSource="${db}" var="count">
        insert into users (username, email, password, phone_number, dob) value
        ('${user.username}', '${user.email}', '${user.password}', '${user.phoneNumber}', '${user.dob}');
      </s:update>
    </c:forEach>


    <%--query which return result set--%>
    <s:query dataSource="${db}" var="rs">
      select * from users;
    </s:query>

    <c:forEach var="tbl" items="${rs.rows}" >
      <c:out value="${tbl.id}" />
      <c:out value="${tbl.username}" />
      <c:out value="${tbl.email}" />
      <br>
    </c:forEach>


  </body>
</html>
