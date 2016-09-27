package wsserver;

import wsserver.dao.BookDao;
import wsserver.model.Book;
import wsserver.model.Books;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;


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

    @WebMethod
    @XmlElementWrapper(name="list")
    @XmlElement(name="books")
    public Books listBook(){
        BookDao dao = new BookDao();
        Books books = new Books();
        books.setBookList(dao.getBooks());
        return books;
    }
}