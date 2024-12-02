/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import model.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 *
 * @author drg
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
	
    public static SessionFactory getSession() {

        if(sessionFactory == null) {
            Configuration conf = new Configuration();

            Properties settings = new Properties();

            settings.setProperty(Environment.DRIVER, "org.postgresql.Driver");
            settings.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/Auca_library_db");
            settings.setProperty(Environment.USER, "postgres");
            settings.setProperty(Environment.PASS, "512000");
            settings.setProperty(Environment.HBM2DDL_AUTO, "create");
            settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.setProperty(Environment.SHOW_SQL, "true");
            settings.setProperty("hibernate.id.new_generator_mappings", "true");
            settings.setProperty(Environment.FORMAT_SQL, "true");

            conf.setProperties(settings);

            conf.addAnnotatedClass(Book.class);
            conf.addAnnotatedClass(Borrower.class);
            conf.addAnnotatedClass(User.class);
            conf.addAnnotatedClass(Location.class);
            conf.addAnnotatedClass(Membership.class);
            conf.addAnnotatedClass(Membership_type.class);
            conf.addAnnotatedClass(Shelf.class);
            conf.addAnnotatedClass(Room.class);
            conf.addAnnotatedClass(Province.class);
            conf.addAnnotatedClass(District.class);
            conf.addAnnotatedClass(Sector.class);
            conf.addAnnotatedClass(Cell.class);
            conf.addAnnotatedClass(Village.class);

            sessionFactory = conf.buildSessionFactory();

            return sessionFactory;

        }else {
            return sessionFactory;
        }
    }

    
}
