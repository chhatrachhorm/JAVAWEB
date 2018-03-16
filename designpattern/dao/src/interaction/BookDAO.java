package interaction;



import model.Book;
import java.util.List;

public interface BookDAO {
    void setConnection();
    Integer insert(Book book);
    Integer delete(String ssn);
    Integer updateTitle(String ssn, String title);
    List<Book> search(String title);
}
