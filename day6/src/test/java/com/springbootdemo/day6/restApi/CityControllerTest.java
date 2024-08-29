package com.springbootdemo.day6.restApi;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootdemo.day6.business.ICityService;
import com.springbootdemo.day6.hibenateJpaEntities.City;

class CityControllerTest {

    @Mock
    private ICityService cityService;

    @InjectMocks
    private CityController cityController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
    }

    @Test
    void testGetAllCities() throws Exception {
        List<City> cities = Arrays.asList(new City(1, "New York", null, null, 0), new City(2, "London", null, null, 0));
        when(cityService.getAll()).thenReturn(cities);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("New York"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("London"));

        verify(cityService, times(1)).getAll();
    }

    @Test
    void testAddCity() throws Exception {
        City city = new City(1, "Paris", null, null, 0);
        ObjectMapper objectMapper = new ObjectMapper();
        String cityJson = objectMapper.writeValueAsString(city);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cityJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(cityService, times(1)).add(any(City.class));
    }

    @Test
    void testUpdateCity() throws Exception {
        City city = new City(1, "Updated City", null, null, 0);
        ObjectMapper objectMapper = new ObjectMapper();
        String cityJson = objectMapper.writeValueAsString(city);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cityJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(cityService, times(1)).update(any(City.class));
    }

    @Test
    void testDeleteCity() throws Exception {
        City city = new City(1, "City to Delete", null, null, 0);
        ObjectMapper objectMapper = new ObjectMapper();
        String cityJson = objectMapper.writeValueAsString(city);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cityJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(cityService, times(1)).delete(any(City.class));
    }

    @Test
    void testGetCityById() throws Exception {
        City city = new City(1, "Test City", null, null, 0);
        when(cityService.getById(1)).thenReturn(city);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test City"));

        verify(cityService, times(1)).getById(1);
    }
}
