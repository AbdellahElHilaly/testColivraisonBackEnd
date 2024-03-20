package com.abdellah.colivraison.security.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.abdellah.colivraison.app.prod.common.validation.annotaion.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {


    @ValidEmail(propertyName = "email")
    private String email;

    @ValidPassword(propertyName = "password")
    private String password;

}