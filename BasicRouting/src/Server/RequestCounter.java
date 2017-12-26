package Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestCounter extends HttpServlet {
    private static void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int count = (int) request.getAttribute("count");
        response.getWriter().println("Your ID is: " + count);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handler(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handler(request, response);
    }
}
