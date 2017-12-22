package Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Info extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        /*
        * Remote Address
        * getRemoteAddr - Returns the IP address of the client or last proxy that sent the request
        * getLocalAddr - Returns the IP address of the interface on which the request was received.
        * */
        String ip = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String localAddress =request.getLocalAddr();
        PrintWriter writer = response.getWriter();
        writer.println("Welcome to crazy java web app " + name);
        writer.println("Your IP is " + ip + "\n Address: " + remoteHost + "\nLocal Address: " + localAddress);
        if (name.equals("ChhatraChhorm") && pass.equals("123456789"))
            writer.println("You Are DisplaySession");
        else writer.println("Access Denied");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
