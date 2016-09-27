package wsserver.model;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<Book> bookList = new ArrayList<Book>();

    public Books() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
