package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;
import com.abdellah.colivraison.app.prod.core.service.ZoneService;
import com.abdellah.colivraison.utils.Const.SuperAdminEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(SuperAdminEndPoints.ZONES)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ZoneController {

    private final ZoneService zoneService;

    @GetMapping
    public ResponseEntity<List<Zone>> findAll() {
        return ResponseEntity.ok(zoneService.findAll());
    }
}
