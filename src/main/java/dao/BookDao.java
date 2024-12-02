package dao;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Book;
import model.Shelf;
import org.hibernate.HibernateException;
import util.HibernateUtil;

public class BookDao {
    
    private Session session;	
	 
    public void saveBookAndAssociateWithShelf(Book book, UUID shelfId) {
       Session session = HibernateUtil.getSession().openSession();
       Transaction transaction = null;

       try {
           transaction = session.beginTransaction();

           Shelf shelf = session.get(Shelf.class, shelfId);
           book.setShelf(shelf);  

           session.save(book);

           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       } finally {
           session.close();
       }
   }
public List<Book> getAvailableBooks() {
       Session session = HibernateUtil.getSession().openSession();
       List<Book> availableBooks = null;

       try {

           String hql = "FROM Book b WHERE b.availableStock > 0";
           Query<Book> query = session.createQuery(hql, Book.class);
           availableBooks = query.list(); 
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }

       return availableBooks;
   }

   // Method to get a book by its ID
   public Book getBookById(UUID bookId) {
       Session session = HibernateUtil.getSession().openSession();
       Book book = null;

       try {
           // Fetch the book by its ID
           book = session.get(Book.class, bookId); // Assuming bookId is an integer
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }

       return book;
   }

   public void updateBook(Book book) {
       Session session = HibernateUtil.getSession().openSession();
       Transaction transaction = null;

       try {
           transaction = session.beginTransaction();


           session.update(book); 

           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       } finally {
           session.close();
       }
   }
   public List showAll() {
        List<Book> list = null;
        session = HibernateUtil.getSession().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            list = session.createQuery("FROM Book", Book.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }

        return list;
    }
}
