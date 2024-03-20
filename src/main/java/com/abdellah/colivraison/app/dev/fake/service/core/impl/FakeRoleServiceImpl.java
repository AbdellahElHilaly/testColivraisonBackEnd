package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakeRoleService;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Privilege;
import com.abdellah.colivraison.app.prod.core.database.model.fake.RoleFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.PrivilegeRepository;
import com.abdellah.colivraison.app.prod.core.database.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FakeRoleServiceImpl implements FakeRoleService {

    private final RoleRepository RoleRepository;
    private final PrivilegeRepository PrivilegeRepository;
    private final RoleFaker RoleFaker;
    private final Random random;
    List<Privilege> privileges;
    List<Role> roles;


    private void saveFake(Role role) {
        Set<Privilege> privilegeSet = new HashSet<>();
        if (privileges.size() > 1) {
            int start = random.nextInt(privileges.size());
            int end = random.nextInt(privileges.size());
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            for (int i = start; i < end; i++) {
                privilegeSet.add(privileges.get(random.nextInt(privileges.size())));
            }
        } else if (random.nextBoolean()) {
            privilegeSet.add(privileges.get(0));
        }
        role.setPrivileges(privilegeSet);





        RoleRepository.save(role);

    }


    @Override
    public void saveFake() {
    }

    @Override
    public void saveFakeList(int size) {

        roles = RoleFaker.generateStaticList();
        privileges = PrivilegeRepository.findAll();


        roles.forEach(this::saveFake);

    }


    @Override
    public void deleteAll() {
        RoleRepository.deleteAll();
    }
}
