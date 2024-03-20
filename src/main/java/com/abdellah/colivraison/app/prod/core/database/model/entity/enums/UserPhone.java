package com.abdellah.colivraison.app.prod.core.database.model.entity.enums;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"number", "user_id"}))
public class UserPhone {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String number;

    @ManyToOne
    @JsonIgnore
    private User user;






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
