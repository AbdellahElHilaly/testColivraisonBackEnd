package com.abdellah.colivraison.app.prod.core.database.model.entity;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Colis {
    @Id
    @GeneratedValue(generator = "UUID")
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


    @ManyToOne
    private City city;

    @ManyToOne
    private Etat etat;

    @ManyToOne
    private Status status;

    @ManyToOne
    private User livreur;

    @ManyToOne
    private User vendor;

    @ManyToOne
    private Rate defaultRate;




    @OneToMany(mappedBy = "colis", fetch = FetchType.EAGER)
    private List<Remarque> remarques;

    @OneToMany(mappedBy = "colis", fetch = FetchType.EAGER)
    private List<ColisPhone> colisPhones;




    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }



}
