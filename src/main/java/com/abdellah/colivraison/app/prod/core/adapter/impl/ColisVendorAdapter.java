package com.abdellah.colivraison.app.prod.core.adapter.impl;

import com.abdellah.colivraison.app.prod.common.validation.helper.ParamsValidator;
import com.abdellah.colivraison.app.prod.core.adapter.ColisAdapter;
import com.abdellah.colivraison.app.prod.core.database.model.dto.request.ColisVendorRequest;
import com.abdellah.colivraison.app.prod.core.database.model.dto.response.ColisVendorResponse;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;
import com.abdellah.colivraison.app.prod.core.database.model.enums.StatusEnum;
import com.abdellah.colivraison.app.prod.core.service.ColisService;
import com.abdellah.colivraison.security.common.principal.UserPrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColisVendorAdapter implements ColisAdapter {

    private final ColisService colisService;
    private final ParamsValidator paramsValidator;
    private final UserPrincipalService userPrincipalService;


    @Override
    public Colis addNewColis(ColisVendorRequest vendorRequest) {
        Colis colis = vendorRequest.toEntity();
        colis.setStatus(Status.builder().name(StatusEnum.CHEZ_VENDEUR.name()).build());
        colis.setVendor(userPrincipalService.getUserPrincipalFromContextHolder());

        return colisService.save(colis);
    }

    @Override
    public Colis updateNewColis(ColisVendorRequest vendorRequest, String uuid) {
        paramsValidator.setPropertyName("colis id");
        Colis colis = colisService.findById(paramsValidator.validateUUID(uuid));
        return colisService.update(vendorRequest.addData(colis));
    }

    @Override
    public Colis demandeRamassage() {
        return ColisAdapter.super.demandeRamassage();
    }

    @Override
    public Page<ColisVendorResponse> getMyColis(Pageable pageable) {
        User user = userPrincipalService.getUserPrincipalFromContextHolder();
        Page<Colis> colisPages = colisService.findAllByVendor(pageable, user);
        return colisPages.map(ColisVendorResponse::fromEntity);
    }


}
