package Server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletConfigContext")
public class ServletConfigContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet Context
        ServletContext context = getServletContext();
        String org = context.getInitParameter("organization");
        // Servlet Config
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        PrintWriter writer = response.getWriter();
        writer.println("Org: " + org + " name: " + name);
    }
}
