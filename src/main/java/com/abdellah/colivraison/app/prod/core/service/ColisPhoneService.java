package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;

import java.util.List;
import java.util.UUID;

public interface ColisPhoneService {
    public List<ColisPhone> findAll();

    ColisPhone save(ColisPhone entity);

    ColisPhone findById(UUID id);

    void deleteAllByColisId(UUID id);

    List<ColisPhone> saveAllWithNewColis(List<ColisPhone> colisPhones, Colis colisSaved);

    List<ColisPhone> saveAllWithOldColis(List<ColisPhone> colisPhones, Colis colis);
}
