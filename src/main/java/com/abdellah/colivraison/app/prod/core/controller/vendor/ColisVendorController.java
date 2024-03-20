package com.abdellah.colivraison.app.prod.core.controller.vendor;


import com.abdellah.colivraison.app.prod.core.adapter.impl.ColisVendorAdapter;
import com.abdellah.colivraison.app.prod.core.database.model.dto.request.ColisVendorRequest;
import com.abdellah.colivraison.app.prod.core.database.model.dto.response.ColisVendorResponse;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.utils.Const.VendorEndPoints;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(VendorEndPoints.COLIS)
@PreAuthorize("hasRole('ROLE_VENDOR')")
public class ColisVendorController {

    private final ColisVendorAdapter colisVendorAdapter;

    @GetMapping
    public ResponseEntity<Page<ColisVendorResponse>> getMyColis(Pageable pageable) {
        Page<ColisVendorResponse> colis = colisVendorAdapter.getMyColis(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(colis);
    }

    @PostMapping
    public ResponseEntity<Colis> addColis(@Valid @RequestBody ColisVendorRequest colisVendorRequest) {
        Colis createdColis = colisVendorAdapter.addNewColis(colisVendorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdColis);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Colis> updateColis(
            @Valid @RequestBody ColisVendorRequest colisVendorRequest, @PathVariable String uuid
    ) {
        Colis updatedColis = colisVendorAdapter.updateNewColis(colisVendorRequest, uuid);
        return ResponseEntity.status(HttpStatus.OK).body(updatedColis);
    }


}
