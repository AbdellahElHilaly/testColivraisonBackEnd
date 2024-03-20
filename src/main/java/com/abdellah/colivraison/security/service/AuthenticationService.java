package com.abdellah.colivraison.security.service;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.security.rest.dto.request.LoginRequest;
import com.abdellah.colivraison.security.rest.dto.response.JwtAuthenticationResponse;
import com.abdellah.colivraison.security.rest.dto.response.JwtRefreshTokenResponse;
import com.abdellah.colivraison.security.rest.dto.response.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface AuthenticationService {


    LoginResponse login(LoginRequest request, HttpServletRequest httpServletRequest);

    JwtRefreshTokenResponse refresh();

    void logout(HttpServletRequest httpServletRequest);

    JwtAuthenticationResponse getTestToken(HttpServletRequest httpServletRequest);
}