package com.abdellah.colivraison.app.prod.core.controller.super_admin;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;
import com.abdellah.colivraison.app.prod.core.service.StatusService;
import com.abdellah.colivraison.utils.Const.SuperAdminEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(SuperAdminEndPoints.STATUSES)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        return ResponseEntity.ok(statusService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Status> findByName(@RequestParam String name) {
        return ResponseEntity.ok(statusService.findByName(name));
    }

}
