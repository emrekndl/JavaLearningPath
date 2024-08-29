package com.springbootdemo.day6.dataAccess;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springbootdemo.day6.hibenateJpaEntities.City;
import jakarta.persistence.EntityManager;

class HibernateCityDalTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    @Mock
    private Query<City> query;

    private HibernateCityDal cityDal;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(entityManager.unwrap(Session.class)).thenReturn(session);
        cityDal = new HibernateCityDal(entityManager);
    }

    @Test
    void testGetAll() {
        List<City> expectedCities = Arrays.asList(new City(), new City());
        when(session.createQuery("from City", City.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedCities);

        List<City> result = cityDal.getAll();

        assertEquals(expectedCities, result);
        verify(session).createQuery("from City", City.class);
        verify(query).getResultList();
    }

    @Test
    void testAdd() {
        City city = new City();
        cityDal.add(city);

        verify(session).merge(city);
    }

    @Test
    void testUpdate() {
        City city = new City();
        cityDal.update(city);

        verify(session).merge(city);
    }

    @Test
    void testDelete() {
        City city = new City();
        city.setId(1);
        City cityToRemove = new City();
        when(session.get(City.class, 1)).thenReturn(cityToRemove);

        cityDal.delete(city);

        verify(session).get(City.class, 1);
        verify(session).remove(cityToRemove);
    }

    @Test
    void testGetById() {
        int id = 1;
        City expectedCity = new City();
        when(session.get(City.class, id)).thenReturn(expectedCity);

        City result = cityDal.getById(id);

        assertEquals(expectedCity, result);
        verify(session).get(City.class, id);
    }

    @Test
    void testGetByIdNotFound() {
        int id = 999;
        when(session.get(City.class, id)).thenReturn(null);

        City result = cityDal.getById(id);

        assertNull(result);
        verify(session).get(City.class, id);
    }
}
