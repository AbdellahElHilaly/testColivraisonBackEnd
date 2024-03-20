package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;

import java.util.List;
import java.util.UUID;

public interface ZoneService {
    public List<Zone> findAll();

    Zone save(Zone entity);

    Zone update(Zone colis);

    void isExistById(UUID id);

    Zone findById(UUID id);
}
