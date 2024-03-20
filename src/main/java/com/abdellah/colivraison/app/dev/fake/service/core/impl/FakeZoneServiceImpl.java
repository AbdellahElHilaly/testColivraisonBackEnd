package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeZoneService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.ZoneFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeZoneServiceImpl implements FakeZoneService {

    private final ZoneRepository ZoneRepository;
    private final ZoneFaker ZoneFaker;


    @Override
    public void saveFakeList(int size) {
        ZoneRepository.saveAll(ZoneFaker.generateList(size));
    }

    @Override
    public void deleteAll() {
        ZoneRepository.deleteAll();
    }
}
