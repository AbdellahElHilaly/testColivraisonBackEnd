package com.abdellah.colivraison.app.prod.core.database.model.entity;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Rate {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private Double rate;

    @ManyToOne
    private City city;

    @ManyToOne
    private StoreCity storeCity;








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
