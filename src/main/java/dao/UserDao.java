package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.User;
import org.hibernate.HibernateException;
import util.HibernateUtil;

public class UserDao {

    private Session session;
    
    public boolean insert(User user) {
        boolean res = false;
        session = HibernateUtil.getSession().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // Save the associated Village if it's not persisted
//            if (user.getLocation() != null && user.getLocation().getId() == null) {
//                session.persist(user.getLocation());
//            }
            session.persist(user);
            tx.commit();
            res = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return res;
        
    }
	 
    public User getUserByUserName(String userName) {
        Session session = HibernateUtil.getSession().openSession();
        User user = session.createQuery("FROM User WHERE userName = :userName", User.class)
                           .setParameter("userName", userName)
                           .uniqueResult();
        session.close();
        return user;
    }
    
    public User findByPhoneNumber(String phone) {
        Session session = HibernateUtil.getSession().openSession();
        User user = session.createQuery("FROM User u WHERE u.phone_number = :phone", User.class)
                           .setParameter("phone", phone)
                           .uniqueResult();
        session.close();
        return user;
    }


    public void updateUser(User user) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user); 
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

    public User getUserById(int userId) {
        Session session = HibernateUtil.getSession().openSession();
        User user = null;

        try {

            user = session.get(User.class, userId); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }
       
    public List showAll() {
        List<User> list = null;
        session = HibernateUtil.getSession().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            list = session.createQuery("FROM User", User.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }

        return list;
    }
}
