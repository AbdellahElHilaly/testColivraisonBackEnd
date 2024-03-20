package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import com.abdellah.colivraison.app.prod.core.service.StoreCityService;
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
@RequestMapping(SuperAdminEndPoints.STORE_CITIES)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class StoreCityController {

    private final StoreCityService storeCityService;

    @GetMapping
    public ResponseEntity<List<StoreCity>> findAll() {
        return ResponseEntity.ok(storeCityService.findAll());
    }



}
