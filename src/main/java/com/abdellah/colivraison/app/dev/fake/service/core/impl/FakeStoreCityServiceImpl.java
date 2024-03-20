package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeStoreCityService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.StoreCityFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.StoreCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeStoreCityServiceImpl implements FakeStoreCityService {
    private final StoreCityRepository storeCityRepository;
    private final StoreCityFaker storeCityFaker;

    @Override
    public void saveFakeList(int size) {
        storeCityRepository.saveAll(storeCityFaker.generateStaticList());
    }

    @Override
    public void deleteAll() {
        storeCityRepository.deleteAll();
    }

}
