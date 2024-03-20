package com.abdellah.colivraison.app.prod.core.database.repository;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmail(String username);

    boolean existsByEmail(String email);

    @Query("SELECT u.role FROM users u WHERE u.email = :email")
    Role getRoleByUserEmail(String email);

    @Query("SELECT u.name FROM users u WHERE u.email = :email")
    String getUserNameByEmail(String email);
}