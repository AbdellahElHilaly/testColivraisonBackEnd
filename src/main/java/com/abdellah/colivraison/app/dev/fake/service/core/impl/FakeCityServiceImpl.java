package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeCityService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.CityFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeCityServiceImpl implements FakeCityService {

    private final CityRepository CityRepository;
    private final CityFaker CityFaker;


    @Override
    public void saveFakeList(int size) {
        CityRepository.saveAll(CityFaker.generateList(size));
    }

    @Override
    public void deleteAll() {
        CityRepository.deleteAll();
    }
}
