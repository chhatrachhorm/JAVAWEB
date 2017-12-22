package Server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if(user.equals("ChhatraChhorm") && pass.equals("123456")){
            Cookie userCk = new Cookie("username", user);
            Cookie passCk = new Cookie("pass", pass);
            response.addCookie(userCk);
            response.addCookie(passCk);
            RequestDispatcher forwarder = request.getRequestDispatcher("/display-cookie");
            forwarder.forward(request, response);
        }else{
            RequestDispatcher forwarder = request.getRequestDispatcher("/");
            forwarder.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
