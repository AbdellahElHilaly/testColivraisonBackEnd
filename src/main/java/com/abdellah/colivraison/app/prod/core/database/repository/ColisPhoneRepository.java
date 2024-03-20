package com.abdellah.colivraison.app.prod.core.database.repository;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ColisPhoneRepository extends JpaRepository<ColisPhone, UUID>, JpaSpecificationExecutor<ColisPhone> {
    void deleteAllByColisId(UUID id);
    List<ColisPhone> findAllByColisId(UUID id);
}