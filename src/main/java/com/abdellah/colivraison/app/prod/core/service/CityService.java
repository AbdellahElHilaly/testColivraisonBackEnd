package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;

import java.util.List;
import java.util.UUID;

public interface CityService {
    public List<City> findAll();

    City save(City entity);

    City update(City colis);

    void isExistById(UUID id);

    City findById(UUID id);
}
