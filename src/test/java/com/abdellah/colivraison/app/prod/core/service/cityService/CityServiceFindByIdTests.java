package com.abdellah.colivraison.app.prod.core.service.cityService;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.model.fake.CityFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.CityRepository;
import com.abdellah.colivraison.app.prod.core.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CityServiceFindByIdTests {
    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private CityFaker cityFaker;

    @Test
    void findExistingCityById() {
        City city = cityFaker.generate();
        Mockito.when(cityRepository.findById(city.getId())).thenReturn(Optional.of(city));

        City foundCity = cityService.findById(city.getId());

        assertNotNull(foundCity);
        assertEquals(city, foundCity);
        Mockito.verify(cityRepository, Mockito.times(1)).findById(city.getId());
    }

    @Test
    void findNonExistingCityById() {
        UUID invalidId = UUID.randomUUID();
        Mockito.when(cityRepository.findById(invalidId)).thenReturn(Optional.empty());

        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> cityService.findById(invalidId));
        Assertions.assertEquals("Ville not found with id: " + invalidId, exception.getMessage());
        Mockito.verify(cityRepository, Mockito.times(1)).findById(invalidId);
    }

    @Test
    void testFindById_TimeComplexity() {
        City city = cityFaker.generate();
        Mockito.when(cityRepository.findById(city.getId())).thenReturn(Optional.of(city));

        long startTime = System.nanoTime();
        cityService.findById(city.getId());
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + executionTime);
        System.out.println("Execution time in milliseconds: " + executionTime / 1000000);

        Assertions.assertTrue(executionTime < 5000000);

    }


}
