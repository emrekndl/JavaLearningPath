package com.springbootdemo.day6.hibenateJpaEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
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
