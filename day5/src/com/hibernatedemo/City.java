package com.hibernatedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents a city in the database. It has fields for the city's
 * id, name, country code, district, and population. The @Entity annotation
 * marks this class as a database entity. The @Table annotation specifies the
 * name of the database table for this entity.
 */

@Entity
@Table(name = "city")
public class City {
    // The @Id annotation marks the id field as the primary key of the entity.
    // The @Column annotations specify the mapping between the fields and the
    // columns in the database table.

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "Name", nullable = false, length = 35)
    private String name;
    @Column(name = "CountryCode", nullable = false, length = 3)
    private String countryCode;
    @Column(name = "District", nullable = false, length = 20)
    private String district;
    @Column(name = "Population", nullable = false)
    private int population;

    public City() {
    }
    public City(String name, String countryCode, String district, int population) {
        this.name = name; 
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}

