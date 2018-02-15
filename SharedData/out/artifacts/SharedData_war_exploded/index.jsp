<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 2/15/2018
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <%@include file="subpages/header.jsp"%>
  <body>
    <% session.setAttribute("invalid-delete-input", null); %>
    <div class="my-wrapper valign-wrapper">
        <div class="row">
            <div class="col s6 offset-s3">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <div class="row no-mb">
                            <span class="card-title col s12">Scope of Your Secret Info</span>
                            <form class="col s12" method="post" action="pages/validate.jsp">
                                <div class="row">
                                    <span class="col s12">Tell us your secret</span>
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input id="icon_prefix" type="text" class="validate" name="secret_info">
                                        <label for="icon_prefix">Your Secret Info</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <span class="col s12 mb-1">Choose your privacy</span>
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
                                <% if(session.getAttribute("invalid-secret-input") != null ){ %>
                                <div class="row red center-align">
                                    <span class="error-text">
                                        <%= session.getAttribute("invalid-secret-input")%>
                                    </span>
                                </div>
                                <%}%>
                                <div class="row center-align no-mb">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>


  </body>
</html>
