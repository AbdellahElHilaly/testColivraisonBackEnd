package com.abdellah.colivraison.security.common.filter;


import com.abdellah.colivraison.app.prod.core.database.repository.UserRepository;
import com.abdellah.colivraison.security.common.exception.CustomAccessDeniedHandler;
import com.abdellah.colivraison.security.common.helper.RequestHelper;
import com.abdellah.colivraison.security.common.jwt.JwtTokenService;
import com.abdellah.colivraison.security.common.principal.UserPrincipalService;
import com.abdellah.colivraison.security.utils.enums.EndPointType;
import com.abdellah.colivraison.security.utils.enums.TokenType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtRefreshTokenFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final RequestHelper requestHelper;
    private final UserRepository userRepository;
    private final UserPrincipalService userPrincipalService;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            if (requestHelper.getEndPointType(request).equals(EndPointType.REFRESH)) {
                String jwtToken = requestHelper.getJwtTokenIfExist(request);
                if (jwtToken == null) {
                    throw new BadRequestException("Refresh token is required");
                }

                if (!jwtTokenService.isTokenValid(jwtToken, TokenType.REFRESH_TOKEN)) {
                    throw new BadRequestException("Invalid token");
                }

                validateRefreshToken(jwtToken, request);

                String username = jwtTokenService.extractUsername(jwtToken);
                setAuthentication(userPrincipalService.loadUserByUsername(username), request);
            }

            filterChain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            customAccessDeniedHandler.handle(request, response, e);
        } catch (RuntimeException e) {
            customAccessDeniedHandler.handle(request, response, new AccessDeniedException(e.getMessage()));
        }
    }

    private void setAuthentication(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    private void validateRefreshToken(String jwtToken, HttpServletRequest request) throws BadRequestException {
        checkUserAgent(jwtToken, request);
        checkIpAddress(jwtToken, request);
        checkUser(jwtToken, request);
    }

    private void checkUser(String jwtToken, HttpServletRequest request) {
        if (!userRepository.existsByEmail(jwtTokenService.extractUsername(jwtToken))) {
            throw new ResourceNotFoundException("User not found with email: " + jwtTokenService.extractUsername(jwtToken));
        }
    }

    private void checkIpAddress(String jwtToken, HttpServletRequest request) throws BadRequestException {
        if (!jwtTokenService.extractIpAddress(jwtToken).equals(requestHelper.getIpAddress(request))) {
            throw new BadRequestException("Invalid ip address");
        }
    }

    private void checkUserAgent(String jwtToken, HttpServletRequest request) throws BadRequestException {
        if (!jwtTokenService.extractUserAgent(jwtToken).equals(requestHelper.getUserAgent(request))) {
            throw new BadRequestException("Invalid user agent");
        }
    }
}
