package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeUserService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;
import com.abdellah.colivraison.app.prod.core.database.model.fake.UserFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.RoleRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.UserRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FakeUserServiceImpl implements FakeUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ZoneRepository zoneRepository;
    private final UserFaker userFaker;
    private List<Role> roles;
    private final Random random;
    private List<Zone> zones;


    @Override
    public void saveFake(User user) {

        user.setZone(zones.get(random.nextInt(zones.size())));

        user.setRole(roles.get(random.nextInt(roles.size())));

        userRepository.save(user);
    }

    @Override
    public void saveFakeList(int size) {
        this.roles = roleRepository.findAll();
        this.zones = zoneRepository.findAll();
        List<User> users = userFaker.generateList(size);

        saveFakeAdmin(users.get(0));
        saveFakeVendor(users.get(1));

        for (int i = 2; i < size; i++) {
            saveFake(users.get(i));
        }


    }

    private void saveFakeVendor(User user) {
        user.setRole(roleRepository.findByName("VENDOR"));
        user.setZone(null);
        userRepository.save(user);
    }

    private void saveFakeAdmin(User user) {
        user.setRole(roleRepository.findByName("ADMIN"));
        user.setZone(null);
        userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
