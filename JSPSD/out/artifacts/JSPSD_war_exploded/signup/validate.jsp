<%@ page import="data.model.User" %><%--
  Created by IntelliJ IDEA.
  UserDAO: chhatrachhorm
  Date: 2/9/18
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="../excepts/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirm_pass = request.getParameter("confirm_pass");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    String dob = request.getParameter("dob");
    System.out.println("LOG: " + username + " " + password + " " + confirm_pass + " " + phone + " " + email + " " + dob);
    try {
        User u = new User(username, password, confirm_pass, dob, phone, email);
        System.out.println("Added New UserDAO " + u.toString());
        out.print("Added new user: " + u.toString());
    } catch (exceptions.InvalidInputDataException e) {
        String message = e.getMessage();
        System.out.println("New UserDAO Exception: " + message);
        out.print("New UserDAO Exception: " + message);
        out.print("Error List " + e.getErrorList());
    }
%>