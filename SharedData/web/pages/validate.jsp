<%--
  Created by IntelliJ IDEA.
  User: chhat
  Date: 2/15/2018
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
    <%

        // request object + request scope
        String[] options = request.getParameterValues("options");
        String userSecret = request.getParameter("secret_info");
        if(options != null && options.length != 0 && userSecret != null){
            for(String o: options){
                out.print("Options: " + o + "<br>");
                Integer scope = o.equals("s_session")?PageContext.SESSION_SCOPE:(o.equals("s_page_context")?PageContext.PAGE_SCOPE:PageContext.APPLICATION_SCOPE);
                // page context object
                pageContext.setAttribute("secret_info", userSecret, scope);

                // sessionScope
                System.out.println("SESSION SCOPE: " + session.getAttribute("secret_info"));
                // pageScope
                System.out.println("PAGE Context SCOPE: " + pageContext.getAttribute("secret_info"));
                // applicationScope
                System.out.println("Application SCOPE: " + application.getAttribute("secret_info"));
            }
            // session object
            session.setAttribute("invalid-secret-input", null);
            // response object
            response.sendRedirect("/pages/dashboard.jsp");
        } else {
          session.setAttribute("invalid-secret-input", "Please Input the Secret info and Choose at least one option");
          response.sendRedirect("/");
        }

    %>