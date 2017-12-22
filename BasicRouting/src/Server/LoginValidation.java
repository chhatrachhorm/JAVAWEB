package Server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class LoginValidation extends HttpServlet {
    private void validation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        LinkedList<String> errorList = new LinkedList<>();
        if(username == null || username.isEmpty()){
            errorList.add("Username is required");
        }
        if(password == null || password.isEmpty()){
            errorList.add("Password is required");
        }
        if(username == null || !username.equals("ChhatraChhorm")){
            errorList.add("Unauthorized User");
        }
        if(password == null || !password.equals("123456789")){
            errorList.add("Password is invalid");
        }
        if(!errorList.isEmpty()){
            request.setAttribute("errorList", errorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login-controller");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login-info");
            dispatcher.forward(request, response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validation(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
