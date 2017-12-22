package filters;

import javax.servlet.*;
import java.io.IOException;

public class ParamFilter implements Filter {
    public void destroy() {
    }

    /**
    * Servlet cannot handle session or cookie 'cause it does not use ServletHttpRequest/Response
    * */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(!(username == null || username.isEmpty())){
            if(!(password == null || password.isEmpty())) {
                chain.doFilter(req, resp);
            }else{
                req.getRequestDispatcher("/").forward(req, resp);
            }
        }else req.getRequestDispatcher("/").forward(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
