<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/7/18
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h1>Welcome Home <%= session.getAttribute("username") %></h1>
    <div>
        <button><a href="hitcounter.jsp">
            Click Here to Go to Global Counter
        </a></button><br>
        <button><a href="usersessionid.jsp">
            Click Here to Go to Your Session ID Counter
        </a></button><br>
        <button><a href="../excepts/runtime.jsp">
            Click Here to Go to Runtime Exception
        </a></button>
    </div>
    <a href="destroy.jsp"><button>Log Out</button></a>
</body>
</html>
