package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Remarque;
import com.abdellah.colivraison.app.prod.core.service.RemarqueService;
import com.abdellah.colivraison.utils.Const.AppEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppEndPoints.REMARQUE)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RemarqueController {
    private final RemarqueService remarqueService;
    @GetMapping
    public ResponseEntity<List<Remarque>> findAll() {
        return ResponseEntity.ok(remarqueService.findAll());
    }
}
