package server;

import impl.BookDaoImpl;
import interaction.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GlobalController", urlPatterns = {"/global-controller"})
public class GlobalController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        BookDAO bookDao = new BookDaoImpl();
        PrintWriter writer = response.getWriter();
        bookDao.setConnection();
        String ssn;
        Integer result;
        switch (operation){
            case "add":
                ssn = request.getParameter("ssn");
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                Integer year = Integer.valueOf(request.getParameter("year"));
                Book b = new Book(null, ssn, title, author, year);
                result = bookDao.insert(b);
                if(result == -1){
                    writer.print("ERROR In adding a new book");
                }else writer.print("Success in Adding a new book");
                break;
            case "delete":
                ssn = request.getParameter("ssn");
                result = bookDao.delete(ssn);
                if(result == -1){
                    writer.print("ERROR In deleting the book");
                }else writer.print("Success in deleting the book");
                break;
            case "shows":
                String searchTitle = request.getParameter("title");
                List<Book> books = bookDao.search(searchTitle);
                if(!books.isEmpty()){
                    writer.println("The result: <br>");
                    for(Book book: books){
                        writer.println(book + "<br>");
                    }
                }else{
                    writer.print("No Book Found");
                }
                break;
            case "update-title":
                String updateTitle = request.getParameter("title");
                ssn = request.getParameter("ssn");
                result = bookDao.updateTitle(ssn, updateTitle);
                if(result == -1){
                    writer.print("ERROR in updating the book");
                }else writer.print("Success in updating the book");
                break;
            default:
                writer.println("Opp! INVALID OPERATION");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
