package server;

import data.ConnectionHolder;
import data.DBHelper;
import exceptions.InvalidInputDataException;
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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

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
        HttpSession session = request.getSession();
        Connection connection;
        try {
//            synchronized (session) {
//                ConnectionHolder holder =
//                        (ConnectionHolder) session.getAttribute("servletapp.connection");
//
//                if (holder == null) {
//                    System.out.println("In holder == null");
//                    try {
//                        Class.forName("com.mysql.cj.jdbc.Driver");
//                        Connection getConnection = DriverManager.getConnection(
//                                "jdbc:mysql://localhost:3306/jspsd", "jspsd", "R*twinklestar15+");
//                        holder = new ConnectionHolder(getConnection);
//                        session.setAttribute("servletapp.connection", holder);
//                    } catch (SQLException e) {
//                        System.out.println("Couldn't get db connection: " + e);
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//                connection = Objects.requireNonNull(holder).getConnection();
//            }
            connection = DBHelper.getDBConnection(session);
            Map<String, Object> results = User.registerUser(username, password, confirm_pass, dob, phone, email, connection);
            if((boolean) results.get("success")){
                User user = (User) results.get("user");
                System.out.println("Added New User " + user.toString());
                out.print("Added new user: " + user.toString());
            }else{
                User user = (User) results.get("user");
                System.out.println("Added New User " + user.toString());
                out.print("Cannot add a new user: " + user.toString());
                out.print("Reason: " + results.get("error"));
            }

        } catch (InvalidInputDataException e) {
            String message = e.getMessage();
            System.out.println("New User Exception: " + message);
            out.print("New User Exception: " + message);
            out.print("Error List " + e.getErrorList());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
