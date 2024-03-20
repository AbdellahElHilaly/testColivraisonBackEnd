package com.abdellah.colivraison.security.rest.controller;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.service.UserService;
import com.abdellah.colivraison.security.common.principal.UserPrincipal;
import com.abdellah.colivraison.security.common.principal.UserPrincipalService;
import com.abdellah.colivraison.security.rest.dto.request.LoginRequest;
import com.abdellah.colivraison.security.rest.dto.response.JwtAuthenticationResponse;
import com.abdellah.colivraison.security.rest.dto.response.JwtRefreshTokenResponse;
import com.abdellah.colivraison.security.rest.dto.response.LoginResponse;
import com.abdellah.colivraison.security.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserPrincipalService userPrincipalService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest registerRequest, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.login(registerRequest, httpServletRequest));
    }


    @GetMapping("/refresh")
    public ResponseEntity<JwtRefreshTokenResponse> getNewAccessToken() {
        return ResponseEntity.ok(authenticationService.refresh());
    }


    //for test
    @GetMapping("/test-token")
    public ResponseEntity<JwtAuthenticationResponse> testToken(HttpServletRequest httpServletRequest) {
        return  ResponseEntity.ok(authenticationService.getTestToken(httpServletRequest));
    }

    //for test
    @GetMapping("/roles")
    public ResponseEntity<Collection<? extends GrantedAuthority>> getRoles() {
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    }

    //for test
    @GetMapping("/principal")
    public ResponseEntity<UserPrincipal> getPrincipal() {
        return ResponseEntity.ok(userPrincipalService.getUserPrincipalFromContextHolder());
    }
    @GetMapping("/profile")
    public ResponseEntity<User> getProfile() {
        return ResponseEntity.ok(userService.getUserByEmail(userPrincipalService.getUserPrincipalFromContextHolder().getEmail()));
    }


}
