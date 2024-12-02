/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Province;
import model.Sector;
import org.hibernate.Session;
import util.HibernateUtil;

public class SectorDao {
    public void save(Sector sector) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.save(sector);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sector findById(Long id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(Sector.class, id);
        }
    }

    public List<Sector> findAll() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.createQuery("FROM Sector", Sector.class).list();
        }
    }
}
