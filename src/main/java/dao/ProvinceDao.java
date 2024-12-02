/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Province;
import org.hibernate.Session;
import util.HibernateUtil;

public class ProvinceDao {
    public void save(Province province) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.merge(province);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Province findById(Long id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(Province.class, id);
        }
    }

    public List<Province> findAll() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.createQuery("FROM Province", Province.class).list();
        }
    }
}


