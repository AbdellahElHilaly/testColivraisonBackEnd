package com.abdellah.colivraison.app.prod.core.database.model.entity;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.UserPhone;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Zone zone;


    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
    private Set<UserPhone> userPhones;






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
