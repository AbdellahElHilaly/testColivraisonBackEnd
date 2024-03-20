package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeStatusService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.StatusFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeStatusServiceImpl implements FakeStatusService {

    private final StatusRepository statusRepository;
    private final StatusFaker statusFaker;


    @Override
    public void saveFakeList(int size) {
        statusRepository.saveAll(statusFaker.generateList(size));
    }

    @Override
    public void deleteAll() {
        statusRepository.deleteAll();
    }
}
