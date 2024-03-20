package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeUserPhoneService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.UserPhone;
import com.abdellah.colivraison.app.prod.core.database.model.fake.UserPhoneFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.UserPhoneRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FakeUserUserPhoneServiceImpl implements FakeUserPhoneService {

    private final UserPhoneRepository UserPhoneRepository;
    private final UserRepository userRepository;
    private final UserPhoneFaker UserPhoneFaker;
    private final Random random;


    private void saveFake() {
        UserPhone userPhone = UserPhoneFaker.generate();

        List<User> users = userRepository.findAll();
        int start = random.nextInt(users.size());
        int end = random.nextInt(users.size());
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i < end; i++) {
            userPhone.setUser(users.get(random.nextInt(users.size())));
        }


        UserPhoneRepository.save(userPhone);
    }

    @Override
    public void saveFakeList(int size) {
        User admin = userRepository.findByEmail("admin@gmail.com").get();
        saveStaticFake(admin, 2);
        User vendor = userRepository.findByEmail("vendor@gmail.com").get();
        saveStaticFake(vendor, 2);

        for (int i = 2; i < size; i++) {
            saveFake();
        }
    }

    private void saveStaticFake(User admin, int size) {
        for (int i = 0; i < size; i++) {
            UserPhone userPhone = UserPhoneFaker.generate();
            userPhone.setUser(admin);
            UserPhoneRepository.save(userPhone);
        }
    }


    @Override
    public void deleteAll() {
        UserPhoneRepository.deleteAll();
    }

}
