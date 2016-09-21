package wsserver.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import wsserver.connection.HibernateConnection;
import wsserver.model.Book;

import java.util.List;

public class BookDao {
    private Session session;

    public BookDao() {
    }

    public boolean addBook(Book book) {
        session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean removeBook(Book book){
        session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean editBook(Book book){
        session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public List getBooks(){
        List books = null;
        session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        books = session.createQuery("from Book order by id").list();
        session.getTransaction().commit();
        session.close();
        return books;
    }

    public Book getBook(Long id){
        session = HibernateConnection.getSessionFactory().openSession();
        Book book = (Book)session.get(Book.class, new Long(id));
        session.close();
        return book;
    }

    public Book findBook(String title){
        session = HibernateConnection.getSessionFactory().openSession();
        Query query = session.createQuery("from Book where title = :title ");
        query.setParameter("title", title);
        Book book = (Book) query.uniqueResult();
        //session.getTransaction().commit();
        session.close();
        return book;
    }

}
