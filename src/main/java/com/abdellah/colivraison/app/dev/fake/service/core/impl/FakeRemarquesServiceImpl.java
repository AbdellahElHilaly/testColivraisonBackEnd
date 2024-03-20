package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeRemarquesService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Remarque;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.model.fake.RemarqueFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.ColisRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.RemarqueRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FakeRemarquesServiceImpl implements FakeRemarquesService {

    private final RemarqueRepository remarqueRepository;
    private final RemarqueFaker remarqueFaker;
    private final ColisRepository colisRepository;
    private final UserRepository userRepository;

    private final List<User> userList = new ArrayList<>();
    private final List<Colis> colisList = new ArrayList<>();
    private final List<Remarque> remarqueList = new ArrayList<>();
    private final Random random;


    private void saveFake(Remarque remarque) {

        int start = random.nextInt(userList.size());
        int end = random.nextInt(userList.size());

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i < end; i++) {
            remarque.setUser(userList.get(random.nextInt(userList.size())));
            remarque.setColis(colisList.get(random.nextInt(colisList.size())));
            remarqueRepository.save(remarque);
        }


    }


    @Override
    public void saveFakeList(int size) {
        userList.clear(); colisList.clear(); remarqueList.clear();
        userList.addAll(userRepository.findAll());
        colisList.addAll(colisRepository.findAll());
        remarqueList.addAll(remarqueFaker.generateList(size));

        remarqueList.forEach(this::saveFake);


    }


    @Override
    public void deleteAll() {
        remarqueRepository.deleteAll();
    }


}
