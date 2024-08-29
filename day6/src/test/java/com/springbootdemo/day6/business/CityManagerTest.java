package com.springbootdemo.day6.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springbootdemo.day6.dataAccess.ICityDal;
import com.springbootdemo.day6.hibenateJpaEntities.City;

class CityManagerTest {

    @Mock
    private ICityDal cityDal;

    @InjectMocks
    private CityManager cityManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll_ReturnsListOfCities() {
        List<City> expectedCities = Arrays.asList(
            new City(1, "New York", null, null, 0),
            new City(2, "London", null, null, 0)
        );
        when(cityDal.getAll()).thenReturn(expectedCities);

        List<City> result = cityManager.getAll();

        assertEquals(expectedCities, result);
        verify(cityDal, times(1)).getAll();
    }

    @Test
    void testGetAll_ReturnsEmptyList() {
        when(cityDal.getAll()).thenReturn(Collections.emptyList());

        List<City> result = cityManager.getAll();

        assertTrue(result.isEmpty());
        verify(cityDal, times(1)).getAll();
    }

    @Test
    void testGetAll_ThrowsException() {
        when(cityDal.getAll()).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> cityManager.getAll());
        verify(cityDal, times(1)).getAll();
    }
}
