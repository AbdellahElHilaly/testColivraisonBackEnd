package com.abdellah.colivraison.app.prod.core.database.repository;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface UserPhoneRepository extends JpaRepository<UserPhone, UUID>, JpaSpecificationExecutor<UserPhone> {
}