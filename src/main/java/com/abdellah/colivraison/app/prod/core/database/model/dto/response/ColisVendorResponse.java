package com.abdellah.colivraison.app.prod.core.database.model.dto.response;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Etat;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ColisVendorResponse {
    private UUID id;

    private String suiviCode;
    private String adresse;
    private String destinataire;
    private String marchandise;

    private Integer quantity;

    private Double price;
    private Double livraisonRate;


    private Boolean fragile;
    private Boolean openable;
    private Boolean colisOfStock;
    private Boolean colisOfReplacement;

    private Date ramassageDate;
    private Date putInStockDate;
    private Date shippingDate;
    private Date deliveryDate;

    private City city;

    private Etat etat;

    private Status status;

    private Rate defaultRate;

    private List<ColisPhone> colisPhones;

    private Date createdAt;

    private Date updatedAt;

    public static List<ColisVendorResponse> fromEntityList(List<Colis> colisList) {
        return colisList.stream().map(ColisVendorResponse::fromEntity).toList();
    }


    public static ColisVendorResponse fromEntity(Colis colis) {
        return ColisVendorResponse.builder()
                .id(colis.getId())
                .suiviCode(colis.getSuiviCode())
                .adresse(colis.getAdresse())
                .destinataire(colis.getDestinataire())
                .marchandise(colis.getMarchandise())
                .quantity(colis.getQuantity())
                .price(colis.getPrice())
                .livraisonRate(colis.getLivraisonRate())
                .fragile(colis.getFragile())
                .openable(colis.getOpenable())
                .colisOfStock(colis.getColisOfStock())
                .colisOfReplacement(colis.getColisOfReplacement())
                .ramassageDate(colis.getRamassageDate())
                .putInStockDate(colis.getPutInStockDate())
                .shippingDate(colis.getShippingDate())
                .deliveryDate(colis.getDeliveryDate())
                .city(colis.getCity())
                .etat(colis.getEtat())
                .status(colis.getStatus())
                .defaultRate(colis.getDefaultRate())
                .colisPhones(colis.getColisPhones())
                .createdAt(colis.getCreatedAt())
                .updatedAt(colis.getUpdatedAt())
                .build();
    }


}
