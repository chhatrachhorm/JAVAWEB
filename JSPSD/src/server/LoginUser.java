package server;

import data.DBHelper;
import model.helper.JWTHelper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

@WebServlet(name = "LoginUser", urlPatterns = {"/loginUser"})
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection connection;
        String identifier = request.getParameter("identifier");
        String pass = request.getParameter("password");
        connection = DBHelper.getDBConnection(session);
        Map<String, Object> results = User.getUser(identifier, pass, connection);
        if((boolean) results.get("success")){
            session.setAttribute("username", results.get("username"));
            session.setAttribute("uid", results.get("username") + (String) results.get("email"));
            session.setAttribute("jwtID", JWTHelper.generateToken((String) results.get("username"), "jspsd", results.get("username") + (String) results.get("email")));
            session.setAttribute("login-error", null);
            response.sendRedirect("/pages/success.jsp");
        }else{
            System.out.println("Access Denied with Message: " + results.get("error"));
            session.setAttribute("login-error", results.get("error"));
            response.sendRedirect("/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
