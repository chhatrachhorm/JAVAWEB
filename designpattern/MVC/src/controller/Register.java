package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        /*
        * Create a Data Transfer Object (DTO) or Bean Object for student
        * Student Model is a bean class
        * */

        Student student = new Student();
        student.setName(name);
        student.setId(id);
        student.setPassword(password);
        student.setEmail(email);

        /*
        * Change the hard coded value to the value from the Database
        * */
        if(student.getEmail().equals("ch.chhatra@gmail.com")
                && student.getPassword().equals("123456")){
            response.sendRedirect("/success.jsp");
            request.getSession().setAttribute("info-error", null);
            request.getSession().setAttribute("student", student);
        }else{
            request.getSession().setAttribute("info-error", "Either the email or the password is incorrect");
            response.sendRedirect("/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
