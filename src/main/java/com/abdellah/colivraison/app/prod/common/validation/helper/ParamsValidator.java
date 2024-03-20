package com.abdellah.colivraison.app.prod.common.validation.helper;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Setter
public class ParamsValidator {
    private String propertyName = "UUID";
    private final String suffix = " in your request URL is not a ";

    public UUID validateUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(propertyName + suffix + "valid UUID");
        }
    }
}
