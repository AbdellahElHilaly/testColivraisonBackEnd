package com.abdellah.colivraison.app.prod.core.controller.vendor;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.service.CityService;
import com.abdellah.colivraison.utils.Const.VendorEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(VendorEndPoints.CITIES)
@PreAuthorize("hasRole('ROLE_VENDOR')")
public class CityVendorController {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
    }
}
