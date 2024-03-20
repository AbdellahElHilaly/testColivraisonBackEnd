package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import com.abdellah.colivraison.app.prod.core.database.repository.StoreCityRepository;
import com.abdellah.colivraison.app.prod.core.service.StoreCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StoreCityServiceImpl implements StoreCityService {
    private final StoreCityRepository storeCityRepository;
    @Override
    public List<StoreCity> findAll() {
        return storeCityRepository.findAll();
    }

    @Override
    public StoreCity save(StoreCity entity) {
        return null;
    }

    @Override
    public StoreCity update(StoreCity colis) {
        return null;
    }

    @Override
    public void isExistById(UUID id) {

    }

    @Override
    public StoreCity findById(UUID id) {
        return null;
    }
}
