package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeColisPhoneService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import com.abdellah.colivraison.app.prod.core.database.model.fake.ColisPhoneFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.ColisPhoneRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.ColisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class FakeColisPhoneServiceImpl implements FakeColisPhoneService {
    private final ColisPhoneFaker colisPhoneFaker;
    private final ColisPhoneRepository colisPhoneRepository;
    private final ColisRepository colisRepository;
    private final Random random;
    private final List<Colis> colisList = new ArrayList<>();
    private final List<ColisPhone> colisPhoneList = new ArrayList<>();

    private void saveFake(ColisPhone colisPhone) {
        List<Colis> colisList = colisRepository.findAll();
        int start = random.nextInt(colisList.size());
        int end = random.nextInt(colisList.size());
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i < end; i++) {
            colisPhone.setColis(colisList.get(random.nextInt(colisList.size())));
        }

        colisPhoneRepository.save(colisPhone);

    }

    @Override
    public void saveFakeList(int size) {
        colisList.clear(); colisPhoneList.clear();
         colisList.addAll(colisRepository.findAll());
         colisPhoneList.addAll(colisPhoneFaker.generateList(size));


        colisPhoneList.forEach(this::saveFake);


    }


    @Override
    public void deleteAll() {
        colisPhoneRepository.deleteAll();
    }
}
