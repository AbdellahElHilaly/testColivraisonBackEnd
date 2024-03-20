package com.abdellah.colivraison.app.prod.core.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ColisService {
    Page<Colis> findAll(Pageable pageable);
    Page<Colis> findAllByVendor(Pageable pageable, User user);


    Colis save(Colis colis);


    void isExistById(UUID id);

    Colis findById(UUID id);

    Colis update(Colis colis);

}
