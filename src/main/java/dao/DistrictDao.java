/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.District;
import org.hibernate.Session;
import util.HibernateUtil;

public class DistrictDao {
    public void save(District district) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.save(district);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public District findById(Long id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(District.class, id);
        }
    }

    public List<District> findAll() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.createQuery("FROM District", District.class).list();
        }
    }
}

