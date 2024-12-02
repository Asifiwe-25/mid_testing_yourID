package dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Book;
import model.Borrower;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class BorrowerDao {

	public void save(Borrower borrower) {

        try {
                Session ss = HibernateUtil.getSession().openSession();
                ss.save(borrower);
                ss.beginTransaction().commit();

        } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
        }
        // TODO Auto-generated method stub
		
	}
	public void saveBorrower(Book book, User user, Date pickupDate, Date returnDate) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Borrower borrower = new Borrower();
            borrower.setBook(book);
            borrower.setUser(user);
            borrower.setPickup_date(pickupDate);
            borrower.setReturn_date(returnDate);

            borrower.setFine(0); 
            borrower.setLate_charge_fees(0);

            // Save the borrower record
            session.save(borrower);

            // Update the book's available stock// Decrement stock by 1
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
    public List<Borrower> viewBorrowedBooks(UUID userId) {
        List<Borrower> borrowedBooks = null;
        Session session = HibernateUtil.getSession().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Borrower b WHERE b.user.person_id = :userId", Borrower.class);
            query.setParameter("userId", userId);
            borrowedBooks = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            Logger.getLogger(BorrowerDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return borrowedBooks;
    }

}
