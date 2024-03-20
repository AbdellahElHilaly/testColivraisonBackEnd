package com.abdellah.colivraison.security.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.service.UserService;
import com.abdellah.colivraison.security.common.jwt.JwtTokenService;
import com.abdellah.colivraison.security.common.principal.UserPrincipalService;
import com.abdellah.colivraison.security.rest.dto.request.LoginRequest;
import com.abdellah.colivraison.security.rest.dto.response.JwtAuthenticationResponse;
import com.abdellah.colivraison.security.rest.dto.response.JwtRefreshTokenResponse;
import com.abdellah.colivraison.security.rest.dto.response.LoginResponse;
import com.abdellah.colivraison.security.service.AuthenticationService;
import com.abdellah.colivraison.security.utils.enums.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final UserPrincipalService userPrincipalService;
    private final UserService userService;

    @Override
    public LoginResponse login(LoginRequest request, HttpServletRequest httpServletRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String access_token = jwtTokenService.generateToken(request.getEmail(), TokenType.ACCESS_TOKEN);
        String refresh_token = jwtTokenService.generateRefreshToken(request.getEmail(), httpServletRequest);

        JwtAuthenticationResponse jwtAuthenticationResponse = JwtAuthenticationResponse.builder()
                .accessToken(access_token)
                .refreshToken(refresh_token)
                .build();

        Role role = userService.getRoleByEmail(request.getEmail());
        String name = userService.getUserNameByEmail(request.getEmail());
        return LoginResponse.builder()
                .jwtAuthenticationResponse(jwtAuthenticationResponse)
                .role(role)
                .name(name)
                .build();
    }



    @Override
    public JwtRefreshTokenResponse refresh() {
        String username =  userPrincipalService.getUserPrincipalFromContextHolder().getUsername();
       return  JwtRefreshTokenResponse.builder()
               .accessToken(jwtTokenService.generateToken(username, TokenType.ACCESS_TOKEN))
               .build();
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest) {

    }

    @Override
    public JwtAuthenticationResponse getTestToken(HttpServletRequest httpServletRequest) {
        return JwtAuthenticationResponse.builder()
                .accessToken(jwtTokenService.generateToken("admin@gmail.com", TokenType.ACCESS_TOKEN))
                .refreshToken(jwtTokenService.generateRefreshToken("admin@gmail.com", httpServletRequest))
                .build();
    }
}
