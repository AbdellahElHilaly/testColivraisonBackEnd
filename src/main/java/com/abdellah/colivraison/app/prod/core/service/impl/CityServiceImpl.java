package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.repository.CityRepository;
import com.abdellah.colivraison.app.prod.core.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public City update(City colis) {
        isExistById(colis.getId());
        return cityRepository.save(colis);
    }

    @Override
    public void isExistById(UUID id) {
        if (cityRepository.existsById(id)) return;
        throw new NoSuchElementException("Ville not found with id: " + id);
    }

    @Override
    public City  findById(UUID id) {
        return cityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Ville not found with id: " + id));
    }
}
