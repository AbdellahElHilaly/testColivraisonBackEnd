package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.repository.ColisRepository;
import com.abdellah.colivraison.app.prod.core.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ColisServiceImpl implements ColisService {
    private final ColisRepository colisRepository;
    private final CityService cityService;
    private final StatusService statusService;
    private final ColisPhoneService colisPhoneService;
    private final UserService userService;

    @Override
    public Page<Colis> findAll(Pageable pageable) {
        return colisRepository.findAll(pageable);
    }

    @Override
    public Page<Colis> findAllByVendor(Pageable pageable, User user) {
        return colisRepository.findAllByVendor(pageable, userService.getUserByEmail(user.getEmail()));
    }

    @Override
    public Colis save(Colis colis) {

        Colis colisSaved = colisRepository.save(checkContain(colis));

        if (colis.getColisPhones() != null) {
            colisSaved.setColisPhones(colisPhoneService.saveAllWithNewColis(colis.getColisPhones(), colisSaved));
        }

        return colisSaved;

    }


    @Override
    public Colis findById(UUID id) {
        return colisRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Colis not found with id: " + id));
    }

    @Override
    public Colis update(Colis colis) {
        checkContain(colis);

        colis.setColisPhones(colisPhoneService.saveAllWithOldColis(colis.getColisPhones(), colis));

        return colisRepository.save(colis);
    }




    @Override
    public void isExistById(UUID id) {
        if (colisRepository.existsById(id)) return;
        throw new NoSuchElementException("Colis not found with id: " + id);
    }


    private Colis checkContain(Colis colis) {

        if (colis.getCity() != null) colis.setCity(cityService.findById(colis.getCity().getId()));


        if (colis.getStatus() != null) {
            if (colis.getStatus().getId() != null) colis.setStatus(statusService.findById(colis.getStatus().getId()));
            else colis.setStatus(statusService.findByName(colis.getStatus().getName()));
        }

        if (colis.getVendor() != null) {
            colis.setVendor(userService.getUserByEmail(colis.getVendor().getEmail()));
        }

        //the vendor can't set this data
        if (colis.getLivreur() != null) {
        }

        if (colis.getEtat() != null) {
        }
        return colis;
    }


}
