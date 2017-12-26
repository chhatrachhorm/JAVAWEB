package Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class RequestCounter extends HttpServlet {
    private static void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int count = (int) request.getAttribute("count");
        if(count == new Random().nextInt(4525) || (count > 100 && count%100 == 0) || count==1)
            response.getWriter().println("Yeah Hoo! You are the winner of today servlet! You cash prize is " + count);
        else response.getWriter().println("Your ID is: " + count);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handler(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handler(request, response);
    }
}
