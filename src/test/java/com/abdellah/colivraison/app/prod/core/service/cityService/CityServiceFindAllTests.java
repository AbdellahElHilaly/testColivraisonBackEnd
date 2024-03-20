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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CityServiceFindAllTests {
    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private CityFaker cityFaker;

    @Test
    void findAll() {
        List<City> expectedCities = cityFaker.generateList(5);
        Mockito.when(cityRepository.findAll()).thenReturn(expectedCities);
        List<City> actualCities = cityService.findAll();
        assertEquals(expectedCities, actualCities);
    }
}
