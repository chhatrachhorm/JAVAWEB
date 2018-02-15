<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 2/15/2018
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../subpages/header.jsp"%>
<body>

    <div class="container-fluid">
        <div class="my-wrapper valign-wrapper">
            <div class="row">
                <div class="col s8 offset-s2">
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">
                            <div class="row no-mb">
                                <span class="card-title col s12">Your Secret Info Dashboard</span>
                                <div class="col s12">
                                    <table class="white-text">
                                        <thead>
                                        <tr>
                                            <th>Scope Name</th>
                                            <th>Value</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>Session</td>
                                            <td><%= session.getAttribute("secret_info") %></td>
                                        </tr>
                                        <tr>
                                            <td>Application Context</td>
                                            <td><%= application.getAttribute("secret_info") %></td>
                                        </tr>
                                        <tr>
                                            <td>Page Context</td>
                                            <td><%= pageContext.getAttribute("secret_info") %></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col s8 offset-s2">
                    <div class="card grey darken-1">
                        <div class="card-content white-text">
                            <div class="row no-mb">
                                <span class="card-title col s12">Delete Your Info from Anywhere</span>
                                <div class="col s12">
                                    <form action="delete.jsp" method="post" class="no-mb">
                                        <div class="row no-mb">
                                            <span class="col s12 mb-1">Choose Where to Delete</span>
                                            <div class="col s12">
                                                <p>
                                                    <input type="checkbox" class="filled-in white-text" id="o1" name="options" value="s_session"/>
                                                    <label for="o1" class="white-text">Session Scope</label>
                                                </p>
                                            </div>
                                            <div class="col s12">
                                                <p>
                                                    <input type="checkbox" class="filled-in" id="o2" name="options" value="s_page_context"/>
                                                    <label for="o2" class="white-text">Page Context Scope</label>
                                                </p>
                                            </div>
                                            <div class="col s12">
                                                <p>
                                                    <input type="checkbox" class="filled-in" id="o3" name="options" value="s_app_context"/>
                                                    <label for="o3" class="white-text">Application Context Scope</label>
                                                </p>
                                            </div>
                                        </div>
                                        <% if(session.getAttribute("invalid-delete-input") != null ){ %>
                                        <div class="row red center-align">
                                            <span class="error-text">
                                                <%= session.getAttribute("invalid-delete-input")%>
                                            </span>
                                        </div>
                                        <%}%>
                                        <div class="row center-align no-mb">
                                            <button class="btn waves-effect waves-light red" type="submit" name="action">Delete
                                                <i class="material-icons right">delete</i>
                                            </button>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</body>
</html>
