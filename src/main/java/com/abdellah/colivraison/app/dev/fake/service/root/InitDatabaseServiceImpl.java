package com.abdellah.colivraison.app.dev.fake.service.root;

import com.abdellah.colivraison.app.dev.fake.service.core.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InitDatabaseServiceImpl implements InitDatabaseService {

    private final FakeStatusService fakeStatusService;
    private final FakeEtatService fakeEtatService;
    private final FakeCityService fakeCityService;
    private final FakeZoneService fakeZoneService;
    private final FakePrivilegeService fakePrivilegeService;
    private final FakeUserPhoneService fakeUserPhoneService;
    private final FakeColisPhoneService fakeColisPhoneService;
    private final FakeStoreCityService fakeStoreCityService;
    private final FakeRateService fakeRateService;


    private final FakeRoleService fakeRoleService;
    private final FakeUserService fakeUserService;
    private final FakeColisService fakeColisService;
    private final FakeRemarquesService fakeRemarquesService;

    @Override
    public void initDatabase(int size) {
        clearDatabase();

        fakeStatusService.saveFakeList(size);
        fakeEtatService.saveFakeList(size);
        fakeCityService.saveFakeList(size);
        fakeZoneService.saveFakeList(size);
        fakePrivilegeService.saveFakeList(size);
        fakeRoleService.saveFakeList(size);

        fakeStoreCityService.saveFakeList(size);

        fakeRateService.saveFakeList(size);
        fakeUserService.saveFakeList(size);
        fakeUserPhoneService.saveFakeList(size);
        fakeColisService.saveFakeList(size);
        fakeColisPhoneService.saveFakeList(size);
        fakeRemarquesService.saveFakeList(size);

    }

    @Override
    public void clearDatabase() {

        fakeRemarquesService.deleteAll();
        fakeColisPhoneService.deleteAll();
        fakeColisService.deleteAll();
        fakeUserPhoneService.deleteAll();
        fakeUserService.deleteAll();
        fakeRateService.deleteAll();
        fakeStoreCityService.deleteAll();



        fakeRoleService.deleteAll();
        fakeStatusService.deleteAll();
        fakeEtatService.deleteAll();
        fakeCityService.deleteAll();
        fakeZoneService.deleteAll();
        fakePrivilegeService.deleteAll();


    }

}