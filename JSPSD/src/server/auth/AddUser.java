package server.auth;


import data.helper.DBHelper;
import exceptions.InvalidInputDataException;
import data.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;


@WebServlet(name = "AddUser", urlPatterns = {"/registerUser"})
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("confirm_pass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        System.out.println("LOG: " + username + " " + password + " " + confirm_pass + " " + phone + " " + email + " " + dob);
        PrintWriter out = response.getWriter();

        // connect database
        HttpSession session = request.getSession();
        Connection connection;

        try {
            connection = DBHelper.getDBConnection(session);
            Map<String, Object> results = User.registerUser(username, password, confirm_pass, dob, phone, email, connection);
            if((boolean) results.get("success")){
                User user = (User) results.get("user");
                System.out.println("Added New UserDAO " + user.toString());
                request.setAttribute("identifier", user.getEmail());
                request.setAttribute("password", user.getPassword());
                session.setAttribute("sign-up-error", null);
                request.getRequestDispatcher("/loginUser").forward(request, response);
            }else{
                User user = (User) results.get("user");
                System.out.println("Cannot add a New UserDAO " + user.toString() + "\nReason: " + results.get("error"));
                session.setAttribute("sign-up-error", "Error in adding a new user due to " + results.get("error"));
                response.sendRedirect("/");
            }
        } catch (InvalidInputDataException e) {
            String message = e.getMessage();
            System.out.println("New UserDAO Exception: " + message);
            out.print("New UserDAO Exception: " + message);
            out.print("Error List " + e.getErrorList());
            int errorSize = e.getErrorList().size();
            if(errorSize == 1){
                session.setAttribute("sign-up-error", "You got an error in " + e.getErrorList().get(0));
            }else{
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("You got errors in ");
                for(String s: e.getErrorList()){
                    errorMessage.append(s).append(", ");
                }
                session.setAttribute("sign-up-error", errorMessage.toString().substring(0, errorMessage.toString().length() - 2));
            }
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
