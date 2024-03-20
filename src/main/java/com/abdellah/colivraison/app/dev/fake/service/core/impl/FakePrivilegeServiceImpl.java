package com.abdellah.colivraison.app.dev.fake.service.core.impl;

import com.abdellah.colivraison.app.dev.fake.service.core.FakePrivilegeService;
import com.abdellah.colivraison.app.prod.core.database.model.fake.PrivilegeFaker;
import com.abdellah.colivraison.app.prod.core.database.repository.PrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakePrivilegeServiceImpl implements FakePrivilegeService {

    private final PrivilegeRepository PrivilegeRepository;
    private final PrivilegeFaker PrivilegeFaker;


    @Override
    public void saveFakeList(int size) {
        PrivilegeRepository.saveAll(PrivilegeFaker.generateList(size));
    }

    @Override
    public void deleteAll() {
        PrivilegeRepository.deleteAll();
    }
}
