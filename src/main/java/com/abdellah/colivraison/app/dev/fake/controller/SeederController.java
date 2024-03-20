package com.abdellah.colivraison.app.dev.fake.controller;

import com.abdellah.colivraison.app.dev.fake.service.root.InitDatabaseService;
import com.abdellah.colivraison.utils.Const.SuperAdminEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(SuperAdminEndPoints.SEEDERS)
public class SeederController {

    private final InitDatabaseService initDatabaseService;

    @GetMapping
    public ResponseEntity<String> seed(@RequestParam int size) {
        initDatabaseService.initDatabase(size);
        return ResponseEntity.ok("Database seeded successfully");
    }




}
