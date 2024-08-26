package com.hibernatedemo;

// import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
                .buildSessionFactory();

        // Unit of Work Design Pattern
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // HQL CRUD
            // from City c where c.name LIKE '%bul%'
            // from City c ORDER BY c.name DESC
            // List<City> cities = session.createQuery("from City c where
            // c.countryCode='TUR'", City.class).getResultList();
            // List<City> cities = session.createQuery("from City").getResultList();
            // List<String> countryCodes = session.createQuery("select c.countryCode from
            // City c GROUP BY c.countryCode", String.class).getResultList();
            // for (String countryCode : countryCodes) {
            // System.out.println(countryCode);
            // }
            // for (City city : cities) {
            // System.out.println(city.getName());
            // }

            // INSERT
            // City city = new City("New York 2", "USA", "New York", 5000000);
            // session.save(city);

            // UPDATE
            // City city = session.get(City.class, 4080);
            // city.setName("New York 3");
            // session.update(city);
            
            // DELETE
            City city = session.get(City.class, 4080);
            session.delete(city);

            session.getTransaction().commit();
            // System.out.println(city.getName() + " city successfuly updated.");
            System.out.println(city.getName() + " city successfuly deleted.");

        } finally {
            sessionFactory.close();
        }
    }
}
