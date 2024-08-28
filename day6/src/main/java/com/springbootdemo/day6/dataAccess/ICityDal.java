package com.springbootdemo.day6.dataAccess;

import java.util.List;

import com.springbootdemo.day6.hibenateJpaEntities.City;

public interface ICityDal {

    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}
