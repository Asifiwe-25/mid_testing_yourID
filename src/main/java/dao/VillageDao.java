/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.util.UUID;
import model.Sector;
import model.Village;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author the-ceo
 */
public class VillageDao {
    public Boolean save(Village village) {
        Boolean vrai = false;
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.save(village);
            session.getTransaction().commit();
            vrai = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vrai;
    }

    public Village findById(UUID id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(Village.class, id);
        }
    }
    
    public Village findByName(String name) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(Village.class, name);
        }
    }

    public List<Village> findAll() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.createQuery("FROM Village", Village.class).list();
        }
    }
}
