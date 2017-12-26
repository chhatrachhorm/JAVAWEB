package filters;

import javax.servlet.*;
import java.io.IOException;

public class CountingFilter implements Filter {
    private static volatile int count = 0;
    private synchronized void incrementCounter(){
        count++;
    }
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        incrementCounter();
        req.setAttribute("count", count);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
