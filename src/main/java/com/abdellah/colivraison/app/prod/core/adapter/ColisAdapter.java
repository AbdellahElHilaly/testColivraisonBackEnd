package com.abdellah.colivraison.app.prod.core.adapter;

import com.abdellah.colivraison.app.prod.core.database.model.dto.request.ColisVendorRequest;
import com.abdellah.colivraison.app.prod.core.database.model.dto.response.ColisVendorResponse;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColisAdapter {
    default Colis addNewColis(ColisVendorRequest colis){
        return null;
    }
    default Colis updateNewColis(ColisVendorRequest vendorRequest, String uuid){
        return null;
    }

    default Colis demandeRamassage(){
        return null;
    }

    public Page<ColisVendorResponse> getMyColis(Pageable pageable);
}
