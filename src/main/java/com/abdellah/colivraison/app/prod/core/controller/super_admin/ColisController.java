package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidUUID;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.service.ColisService;
import com.abdellah.colivraison.utils.Const.SuperAdminEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(SuperAdminEndPoints.COLIS)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ColisController {

    private final ColisService colisService;

    @GetMapping
    public ResponseEntity<Page<Colis>> findAll(Pageable pageable) {
        return ResponseEntity.ok(colisService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Colis> findById(@PathVariable @ValidUUID(propertyName = "colis id") String id) {
        return ResponseEntity.ok(colisService.findById(UUID.fromString(id)));
    }

}
