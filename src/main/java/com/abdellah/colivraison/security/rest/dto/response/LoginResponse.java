package com.abdellah.colivraison.security.rest.dto.response;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String name;

    private JwtAuthenticationResponse jwtAuthenticationResponse;
    private Role role;

}
