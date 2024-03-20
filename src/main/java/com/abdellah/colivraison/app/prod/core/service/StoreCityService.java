package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;

import java.util.List;
import java.util.UUID;

public interface StoreCityService {
    public List<StoreCity> findAll();

    StoreCity save(StoreCity entity);

    StoreCity update(StoreCity colis);

    void isExistById(UUID id);

    StoreCity findById(UUID id);
}
