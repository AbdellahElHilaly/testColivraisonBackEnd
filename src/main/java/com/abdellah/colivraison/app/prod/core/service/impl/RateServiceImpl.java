package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;
import com.abdellah.colivraison.app.prod.core.database.repository.RateRepository;
import com.abdellah.colivraison.app.prod.core.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;
    @Override
    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    @Override
    public Rate save(Rate entity) {
        return null;
    }

    @Override
    public Rate update(Rate colis) {
        return null;
    }

    @Override
    public void isExistById(UUID id) {

    }

    @Override
    public Rate findById(UUID id) {
        return null;
    }
}
