package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример вызова через JNDI
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public List<Region> getRegionList() {
        Session s = getSessionFactory().getCurrentSession();
        s.beginTransaction();
        List<Region> regionList = s.createQuery("from Region").list();
        s.getTransaction().commit();
        return regionList;
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
