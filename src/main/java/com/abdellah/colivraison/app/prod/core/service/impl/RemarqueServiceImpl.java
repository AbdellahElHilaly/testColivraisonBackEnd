package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Remarque;
import com.abdellah.colivraison.app.prod.core.database.repository.RemarqueRepository;
import com.abdellah.colivraison.app.prod.core.service.RemarqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RemarqueServiceImpl implements RemarqueService {
    private final RemarqueRepository remarqueRepository;
    @Override
    public List<Remarque> findAll() {
        return remarqueRepository.findAll();
    }
}
