package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeEtatService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.EtatFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.EtatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeEtatServiceImpl implements FakeEtatService {

    private final EtatRepository EtatRepository;
    private final EtatFaker EtatFaker;

    @Override
    public void saveFakeList(int size) {
        EtatRepository.saveAll(EtatFaker.generateList(size));
    }

    @Override
    public void deleteAll() {
        EtatRepository.deleteAll();
    }
}
