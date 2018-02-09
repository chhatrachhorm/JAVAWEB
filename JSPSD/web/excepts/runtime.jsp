<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/9/18
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <main>
        <div>
            <h3>Be Alerted about Number Based Exception</h3>
            <form action="numberresult.jsp" method="post">
                <label>First Number: <input type="text" name="fnum"></label>
                <label>Second Number: <input type="text" name="snum"></label>
                <input type="submit">
            </form>
        </div>
        <div>
            <h3>Be careful of Array Index out Of Bound</h3>
            <form action="arrayresult.jsp" method="post">
                <label>Size of Array: <input type="number" name="arraySize"></label><br>
                <label>Elements:
                    <textarea name="arrayElements" cols="30" rows="10" placeholder="Enter each element separate by comma">
                    </textarea>
                </label>
                <input type="hidden" name="isArray" value="1">
                <button type="submit">Display Whole Array</button>
            </form>
        </div>
    </main>
</body>
</html>
