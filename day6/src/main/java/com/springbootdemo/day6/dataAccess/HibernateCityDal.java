package com.springbootdemo.day6.dataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootdemo.day6.hibenateJpaEntities.City;
import jakarta.persistence.EntityManager;


@Repository
public class HibernateCityDal implements ICityDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // AOP - Aspect Oriented Programming
    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        return cities;
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(city);
        // session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToRemove = session.get(City.class, city.getId());
        session.remove(cityToRemove);
    }
    
    @Override
    @Transactional
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

}
