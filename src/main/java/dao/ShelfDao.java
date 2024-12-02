package dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Room;
import model.Shelf;
import util.HibernateUtil;

public class ShelfDao {
	 public void saveShelf(Shelf shelf, UUID roomId) {
	        Session session = HibernateUtil.getSession().openSession();
	        Transaction transaction = null;
	        
	        try {
	            transaction = session.beginTransaction();
	            
	        
	            Room room = session.get(Room.class, roomId);
	            shelf.setRoom(room);  
	            
	            session.save(shelf);
	            
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
	 
	 public List<Shelf> getAllShelves() {
	        Session session = HibernateUtil.getSession().openSession();
	        try {
	            Query<Shelf> query = session.createQuery("FROM Shelf", Shelf.class);
	            return query.list();
	        } finally {
	            session.close();
	        }
	    }

	    public Shelf getShelfById(UUID shelfId) {
	        Session session = HibernateUtil.getSession().openSession();
	        try {
	            return session.get(Shelf.class, shelfId);  // Get the shelf by its ID
	        } finally {
	            session.close();
	        }
	    }
}
