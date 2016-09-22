package wsserver;

import wsserver.dao.BookDao;
import wsserver.model.Book;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class BookStorage {

    @WebMethod(operationName = "find")
    public Book find(@WebParam(name = "title")
                      String title) {
        BookDao dao = new BookDao();
        return dao.findBook(title);
    }

    @WebMethod(operationName = "create")
    public void create(@WebParam(name = "title") String title,
                       @WebParam(name = "autor") String autor,
                       @WebParam(name = "type") String type) {
        Book book = new Book();
        BookDao bookDao = new BookDao();
        book.setAutor(autor);
        book.setTitle(title);
        book.setType(type);
        bookDao.addBook(book);
    }

    @WebMethod(operationName = "list")
    public ArrayList<Book> listBook(){
        ArrayList books = new ArrayList();
        BookDao dao = new BookDao();
        books.addAll(dao.getBooks());
        return books;
    }
}