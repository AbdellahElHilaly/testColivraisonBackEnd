package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.service.CityService;
import com.abdellah.colivraison.utils.Const.SuperAdminEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping(SuperAdminEndPoints.CITIES)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<City> findById(@PathVariable UUID uuid) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findById(uuid));
    }




}
