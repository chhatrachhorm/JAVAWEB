<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 2/15/2018
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%

    String[] options = request.getParameterValues("options");
    if(options != null && options.length != 0){
        for(String o: options){
            out.print("Options: " + o + "<br>");
            Integer scope = o.equals("s_session")?PageContext.SESSION_SCOPE:(o.equals("s_page_context")?PageContext.PAGE_SCOPE:PageContext.APPLICATION_SCOPE);
            pageContext.setAttribute("secret_info", null, scope);
        }
        session.setAttribute("invalid-delete-input", null);
        response.sendRedirect("/pages/dashboard.jsp");
    } else {
        session.setAttribute("invalid-delete-input", "Please at least choose one scope to delete");
        response.sendRedirect("/pages/dashboard.jsp");
    }

%>
