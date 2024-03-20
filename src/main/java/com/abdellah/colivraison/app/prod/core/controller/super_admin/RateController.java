package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;
import com.abdellah.colivraison.app.prod.core.service.RateService;
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
@RequestMapping(SuperAdminEndPoints.RATES)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RateController {

    private final RateService rateService;
    @GetMapping
    public ResponseEntity<List<Rate>> findAll() {
        return ResponseEntity.ok(rateService.findAll());
    }
}
