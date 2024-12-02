package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Room;
import util.HibernateUtil;

public class RoomDao {
	
	public void saveRoom(Room room) {
		
		try {
			
			Session ss = HibernateUtil.getSession().openSession();
			ss.save(room);
			ss.beginTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public List<Room> getAllRooms() {
        Session session = HibernateUtil.getSession().openSession();
        try {
            Query<Room> query = session.createQuery("FROM Room", Room.class);
            return query.list();
        } finally {
            session.close();
        }
    }

}
