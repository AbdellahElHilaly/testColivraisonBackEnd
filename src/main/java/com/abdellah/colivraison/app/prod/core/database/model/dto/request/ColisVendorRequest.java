package com.abdellah.colivraison.app.prod.core.database.model.dto.request;


import com.abdellah.colivraison.app.prod.common.validation.annotaion.*;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ColisVendorRequest {

    @ValidString(propertyName = "adresse", min = 20)
    private String adresse;

    @ValidDouble(propertyName = "price")
    private String price;

    @ValidString(propertyName = "destinataire", min = 4)
    private String destinataire;

    @ValidString(propertyName = "marchandise", min = 4)
    private String marchandise;

    @ValidInteger(propertyName = "quantity", min = 1)
    private String quantity;


    @ValidBoolean(propertyName = "fragile")
    private String fragile;

    @ValidBoolean(propertyName = "openable")
    private String openable;

    @ValidBoolean(propertyName = "colis of stock")
    private String colisOfStock;

    @ValidBoolean(propertyName = "colis of replacement")
    private String colisOfReplacement;

    @ValidUUID(propertyName = "city id")
    private String cityId;

    @ValidPhoneList(propertyName = "colis phones")
    private List<String> colisPhones;


    public Colis toEntity() {
        return Colis.builder()
                .adresse(adresse)
                .price(Double.parseDouble(price))
                .destinataire(destinataire)
                .marchandise(marchandise)
                .quantity(Integer.parseInt(quantity))
                .fragile(Boolean.parseBoolean(fragile))
                .openable(Boolean.parseBoolean(openable))
                .colisOfStock(Boolean.parseBoolean(colisOfStock))
                .colisOfReplacement(Boolean.parseBoolean(colisOfReplacement))
                .city(City.builder().id(UUID.fromString(cityId)).build())
                .colisPhones(colisPhones.stream().map(phone -> ColisPhone.builder().number(phone).build()).toList())
                .build();
    }

    public Colis addData(Colis oldColis) {
        oldColis.setAdresse(adresse);
        oldColis.setPrice(Double.parseDouble(price));
        oldColis.setDestinataire(destinataire);
        oldColis.setMarchandise(marchandise);
        oldColis.setQuantity(Integer.parseInt(quantity));
        oldColis.setFragile(Boolean.parseBoolean(fragile));
        oldColis.setOpenable(Boolean.parseBoolean(openable));
        oldColis.setColisOfStock(Boolean.parseBoolean(colisOfStock));
        oldColis.setColisOfReplacement(Boolean.parseBoolean(colisOfReplacement));
        oldColis.setCity(City.builder().id(UUID.fromString(cityId)).build());
        oldColis.setColisPhones(colisPhones.stream().map(phone -> ColisPhone.builder().number(phone).build()).toList());
        return oldColis;
    }

}
