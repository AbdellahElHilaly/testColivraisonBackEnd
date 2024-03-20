package com.abdellah.colivraison.app.dev.fake.service.core;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;

public interface FakeUserService {
    public void saveFake(User user);
    public void saveFakeList(int size);
    public void deleteAll();
}
