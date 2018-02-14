package data;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DBHelper {
    public static Connection getDBConnection(HttpSession session){
        synchronized (session) {
            ConnectionHolder holder =
                    (ConnectionHolder) session.getAttribute("servletapp.connection");

            if (holder == null) {
                System.out.println("In holder == null");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection getConnection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/jspsd", "jspsd", "R*twinklestar15+");
                    holder = new ConnectionHolder(getConnection);
                    session.setAttribute("servletapp.connection", holder);
                } catch (SQLException e) {
                    System.out.println("Couldn't get db connection: " + e);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return Objects.requireNonNull(holder).getConnection();
        }
    }
}
