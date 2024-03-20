package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.repository.RoleRepository;
import com.abdellah.colivraison.app.prod.core.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository RoleRepository;

    @Override
    public List<Role> findAll() {
        return RoleRepository.findAll();
    }


}
