package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<User> findAll();

    User getUserByEmail(String username);

    Role getRoleByEmail(String email);

    String getUserNameByEmail(String email);

}
