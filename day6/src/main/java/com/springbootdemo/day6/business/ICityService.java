package com.springbootdemo.day6.business;

import java.util.List;

import com.springbootdemo.day6.hibenateJpaEntities.City;

public interface ICityService {

    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}
