package Server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSession extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pass = req.getParameter("password");
        if (name.equals("ChhatraChhorm") && pass.equals("123456")){
            HttpSession loginSession = req.getSession();
            loginSession.setAttribute("username", name);
            loginSession.setAttribute("password", pass);
            RequestDispatcher rd = req.getRequestDispatcher("/display-session");
            rd.forward(req, resp);
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("/");
            rd.forward(req, resp);
        }
    }
}
