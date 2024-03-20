package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeColisService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.fake.ColisFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class FakeColisServiceImpl implements FakeColisService {

    private final ColisRepository colisRepository;


    private final StatusRepository statusRepository;
    private final CityRepository cityRepository;
    private final EtatRepository etatRepository;
    private final UserRepository userRepository;

    private final ColisFaker colisFaker;
    private final Random random;

    @Override
    public void saveFake() {
        Colis colis = colisFaker.generate();

        colis.setStatus(statusRepository.findAll().get(random.nextInt(statusRepository.findAll().size())));
        colis.setCity(cityRepository.findAll().get(random.nextInt(cityRepository.findAll().size())));
        colis.setEtat(etatRepository.findAll().get(random.nextInt(etatRepository.findAll().size())));
        colis.setVendor(userRepository.findAll().get(random.nextInt(userRepository.findAll().size())));
        colis.setLivreur(userRepository.findAll().get(random.nextInt(userRepository.findAll().size())));

        colisRepository.save(colis);


    }

    @Override
    public void saveFakeList(int size) {
        deleteAll();
        for (int i = 0; i < size; i++) {
            saveFake();
        }
    }

    @Override
    public void deleteAll() {

        colisRepository.deleteAll();

    }
}
