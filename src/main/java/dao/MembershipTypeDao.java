package dao;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import model.Membership_type;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class MembershipTypeDao {
	
	public void save(Membership_type membershipType) {
        
        try {
        	Session session = HibernateUtil.getSession().openSession();
            session.save(membershipType);
            session.beginTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
            
    }
	}
	
	 public List<Membership_type> getAllMembershipTypes() {
	        Session session = HibernateUtil.getSession().openSession();
	        List<Membership_type> membershipTypes = session.createQuery("FROM Membership_type", Membership_type.class).list();
	        session.close();
	        return membershipTypes;
	    }
	 
	 public Membership_type getMembershipTypeById(UUID membershipTypeId) {
	        Session session = HibernateUtil.getSession().openSession();
	        Membership_type membershipType = session.get(Membership_type.class, membershipTypeId);
	        session.close();
	        return membershipType;
	    }
         public Membership_type getMembershipTypeByName(String name) {
            List<Membership_type> list = null;
            Membership_type mt = null;
            Session session = HibernateUtil.getSession().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Query query = session.createQuery("FROM Membership_type mt WHERE mt.membership_name = :name", Membership_type.class);
                query.setParameter("name", name);
                list = query.list();
                mt = list != null && !list.isEmpty() ? list.get(0) : null;
                tx.commit();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                Logger.getLogger(MembershipTypeDao.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                session.close();
            }

            return mt;
	    }

}
