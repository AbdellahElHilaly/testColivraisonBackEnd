package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;

import java.util.List;
import java.util.UUID;

public interface StatusService {
    public List<Status> findAll();
    public Status findByName(String name);

    Status findById(UUID id);
}
