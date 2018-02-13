package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {
        "/pages/success.jsp",
        "/pages/usersessionid.jsp",
        "/pages/destroy.jsp"
})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Going through auth filter");
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        String uid = (String) session.getAttribute("uid");
        if(uid == null || uid.isEmpty()){
            ((HttpServletResponse)resp).sendRedirect("/");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
