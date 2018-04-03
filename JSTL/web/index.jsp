<%--
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
    <s:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3308/jspsd" user="jspsd" password="R*twinklestar15+"/>

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
