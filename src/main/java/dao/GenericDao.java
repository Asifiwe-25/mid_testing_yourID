package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GenericDao<T> {
    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the error
        }
    }

    public T find(Long id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.find(entityClass, id);
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        }
    }
}

