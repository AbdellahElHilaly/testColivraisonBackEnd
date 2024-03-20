package com.abdellah.colivraison.app.prod.core.database.repository;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreCityRepository extends JpaRepository<StoreCity, UUID>, JpaSpecificationExecutor<StoreCity> {
}