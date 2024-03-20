package com.abdellah.colivraison.app.prod.core.database.repository;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColisRepository extends JpaRepository<Colis, UUID>, JpaSpecificationExecutor<Colis> {
    Page<Colis> findAllByVendor(Pageable pageable, User vendor);
    Page<Colis> findAllByLivreur(Pageable pageable, User livreur);
}