package com.abdellah.colivraison.app.prod.core.service;


import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;

import java.util.List;
import java.util.UUID;

public interface RateService {
    public List<Rate> findAll();

    Rate save(Rate entity);

    Rate update(Rate colis);

    void isExistById(UUID id);

    Rate findById(UUID id);
}
