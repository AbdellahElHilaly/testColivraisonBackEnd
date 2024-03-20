package com.abdellah.colivraison.security.common.exception;

import com.abdellah.colivraison.exception.mapper.ErrorSimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    public CustomAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException exc) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        ErrorSimpleResponse errorResponse = new ErrorSimpleResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMessage("Access Denied");
        errorResponse.setDetails(Collections.singletonList(exc.getMessage()));
        errorResponse.setPath(request.getRequestURI());

        PrintWriter out = response.getWriter();
        out.print(objectMapper.writeValueAsString(errorResponse));
        out.flush();
    }
}
