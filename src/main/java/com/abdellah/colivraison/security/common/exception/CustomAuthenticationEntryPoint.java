package com.abdellah.colivraison.security.common.exception;

import com.abdellah.colivraison.exception.mapper.ErrorSimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        ErrorSimpleResponse errorResponse = new ErrorSimpleResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMessage("Authorization Error");

        List<String> details = new ArrayList<>();
        details.add(authException.getMessage());
        errorResponse.setDetails(details);

        errorResponse.setPath(request.getRequestURI());

        PrintWriter out = response.getWriter();
        out.print(objectMapper.writeValueAsString(errorResponse));
        out.flush();
    }
}
