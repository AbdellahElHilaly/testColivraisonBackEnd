package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeRateService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import com.abdellah.colivraison.app.prod.core.database.model.fake.RateFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.CityRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.RateRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.StoreCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class FakeRateServiceImpl implements FakeRateService {

    private final RateRepository rateRepository;
    private final StoreCityRepository storeCityRepository;
    private final CityRepository cityRepository;

    private final RateFaker rateFaker;
    private final Random random;

    private void saveStaticList() {
        List<City> villes = cityRepository.findAll();
        List<StoreCity> storeCities = storeCityRepository.findAll();

        villes.forEach(ville -> {
            Rate rate = rateFaker.generate();
            rate.setCity(ville);
            rate.setStoreCity(storeCities.get(random.nextInt(storeCities.size())));
            rateRepository.save(rate);
        });
    }


    @Override
    public void saveFakeList(int size) {
        saveStaticList();
    }

    @Override
    public void deleteAll() {
        rateRepository.deleteAll();
    }
}
