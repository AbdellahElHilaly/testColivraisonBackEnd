package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;
import com.abdellah.colivraison.app.prod.core.database.repository.StatusRepository;
import com.abdellah.colivraison.app.prod.core.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class statusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findByName(String name) {
        return statusRepository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Status with name " + name + " not found")
        );
    }

    @Override
    public Status findById(UUID id) {
        return statusRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Status with id " + id + " not found")
        );
    }
}
