package dao;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.*;

import model.Membership;
import model.Status;
import util.HibernateUtil;

public class MembershipDao {
    
    private Session session;
    
    public boolean insert(Membership pojo) {
        boolean res = false;
        session = HibernateUtil.getSession().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(pojo);
            tx.commit();
            res = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return res;
    }
	 
	public List<Membership> getPendingRequests() {
	        Session session = HibernateUtil.getSession().openSession();
	        List<Membership> pendingRequests = session.createQuery("FROM Membership m WHERE m.status = :status", Membership.class)
	                .setParameter("status", Status.PENDING)
	                .list();
	        session.close();
	        return pendingRequests;
	    }

	    public void updateMembershipStatus(UUID membershipId, Status status) {
	        
                try {

                        Session session = HibernateUtil.getSession().openSession();
                Transaction tx = session.beginTransaction();
                Membership membership = session.get(Membership.class, membershipId);
                if (membership != null) {
                    membership.setStatus(status);
                    session.update(membership);
                }
                tx.commit();
                session.close();

                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
	    	

}
}

