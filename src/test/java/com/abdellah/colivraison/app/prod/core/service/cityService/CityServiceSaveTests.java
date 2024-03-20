package com.abdellah.colivraison.app.prod.core.service.cityService;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.model.fake.CityFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.CityRepository;
import com.abdellah.colivraison.app.prod.core.service.CityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CityServiceSaveTests {
    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private CityFaker cityFaker;

    @Test
    void testSaveCity_Success() {
        City city = cityFaker.generate();
        Mockito.when(cityRepository.save(any(City.class))).thenReturn(city);
        City savedCity = cityService.save(city);
        assertNotNull(savedCity);
        assertEquals(city, savedCity);
    }

    @Test
    void testSaveCity_Failure() {
        Mockito.when(cityRepository.save(any(City.class))).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> cityService.save(new City()));
    }















}
