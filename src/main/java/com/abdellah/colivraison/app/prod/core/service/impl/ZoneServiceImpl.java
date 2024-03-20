package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;
import com.abdellah.colivraison.app.prod.core.database.repository.ZoneRepository;
import com.abdellah.colivraison.app.prod.core.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository zoneRepository;
    @Override
    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone save(Zone entity) {
        return zoneRepository.save(entity);
    }

    @Override
    public Zone update(Zone colis) {
        isExistById(colis.getId());
        return zoneRepository.save(colis);
    }

    @Override
    public void isExistById(UUID id) {
        if(zoneRepository.existsById(id)) return;
        throw new NoSuchElementException("Zone not found with id: " + id);
    }

    @Override
    public Zone findById(UUID id) {
        return zoneRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Zone not found with id: " + id));
    }
}
