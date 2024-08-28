package com.springbootdemo.day6.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.day6.business.ICityService;
import com.springbootdemo.day6.hibenateJpaEntities.City;


@RestController
@RequestMapping("/api")
public class CityController {
    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }
    
    @GetMapping("/cities")
    public List<City> get() {
        return cityService.getAll();
    }
    
    @PostMapping("/add")
    public void add(@RequestBody City city) {
        cityService.add(city);
    }
    
    @PostMapping("/update")
    public void update(@RequestBody City city) {
        cityService.update(city);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody City city) {
        cityService.delete(city);
    }

    @GetMapping("/cities/{id}")
    public City getById(@PathVariable int id) {
        return cityService.getById(id);
    }
    

}
