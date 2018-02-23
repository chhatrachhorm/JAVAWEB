package server.auth;

import data.DBHelper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteUser", urlPatterns = {"/deleteUser"})
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("currentUser") != null){
            User currentUser = (User) session.getAttribute("currentUser");
            Connection connection = DBHelper.getDBConnection(session);
            try {
                if(User.deleteUser(currentUser, connection)){
                    session.invalidate();
                    session.setMaxInactiveInterval(0);
                    response.sendRedirect("/");
                    return;
                }else {
                    session.setAttribute("delete-user-error", "Error in deleting your account");
                }
            } catch (SQLException e) {
                session.setAttribute("delete-user-error", "Error in deleting your account due to " + e.getMessage());
                e.printStackTrace();
            }
            response.sendRedirect("pages/success.jsp");
        }else{
            response.sendRedirect("/");
        }
    }
}
