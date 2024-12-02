package dao;

import model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LocationDao {
    public void saveLocation(Location location) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
