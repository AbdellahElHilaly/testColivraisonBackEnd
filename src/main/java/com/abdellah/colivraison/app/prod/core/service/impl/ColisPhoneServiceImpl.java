package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import com.abdellah.colivraison.app.prod.core.database.repository.ColisPhoneRepository;
import com.abdellah.colivraison.app.prod.core.service.ColisPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ColisPhoneServiceImpl implements ColisPhoneService {

    private final ColisPhoneRepository colisPhoneRepository;

    @Override
    public List<ColisPhone> findAll() {
        return colisPhoneRepository.findAll();
    }

    @Override
    public ColisPhone save(ColisPhone entity) {
        return colisPhoneRepository.save(entity);
    }

    @Override
    public ColisPhone findById(UUID id) {
        return colisPhoneRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ColisPhone not found with id: " + id)
        );
    }

    @Override
    public void deleteAllByColisId(UUID id) {
        colisPhoneRepository.deleteAllByColisId(id);
    }

    @Override
    public List<ColisPhone> saveAllWithNewColis(List<ColisPhone> colisPhones, Colis colis) {
        List<ColisPhone> newColisPhones = new ArrayList<>();
        for (ColisPhone colisPhone : colisPhones) {
            if (colisPhone.getColis() == null) {
                colisPhone.setColis(colis);
                newColisPhones.add(colisPhone);
            }
        }
        return colisPhoneRepository.saveAll(newColisPhones);
    }

@Override
public List<ColisPhone> saveAllWithOldColis(List<ColisPhone> colisPhones, Colis colis) {
    List<ColisPhone> existingColisPhones = colisPhoneRepository.findAllByColisId(colis.getId());
    List<ColisPhone> colisPhonesToDelete = new ArrayList<>(existingColisPhones);
    colisPhonesToDelete.removeAll(colisPhones);
    colisPhoneRepository.deleteAll(colisPhonesToDelete);

    List<ColisPhone> newColisPhones = new ArrayList<>(colisPhones);
    newColisPhones.removeAll(existingColisPhones);
    newColisPhones.forEach(colisPhone -> colisPhone.setColis(colis));
    return colisPhoneRepository.saveAll(newColisPhones);
}

}
