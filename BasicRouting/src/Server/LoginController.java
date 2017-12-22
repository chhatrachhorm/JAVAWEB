package Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class LoginController extends HttpServlet {
    private void controller(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        LinkedList<String> errorList = (LinkedList<String>) request.getAttribute("errorList");
        PrintWriter writer = response.getWriter();
        if(errorList != null){
            writer.println("<font color=\"red\">");
            writer.println("<h1>Error Occur: </h1>");
            for(String e: errorList){
                writer.println("<span>" + e + "</span><br>");
            }
            writer.println("</font>");
        }
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<form action='login-validation' method='post'>");
        writer.println("Username: <input type='text' name='user'><br>");
        writer.println("Password: <input type='password' name='pass'><br>");
        writer.println("<input type='submit' value='submit'>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }
}
