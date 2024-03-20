package com.abdellah.colivraison.security.common.helper;

import com.abdellah.colivraison.security.utils.enums.EndPointType;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestHelper {

    public EndPointType getEndPointType(HttpServletRequest httpServletRequest) {

        String endpoint = httpServletRequest.getRequestURI();

        if (endpoint.equals("/api/v1/auth/refresh")) return EndPointType.REFRESH;

        if (endpoint.contains("/api/v1/auth/")) return EndPointType.AUTH;

        return EndPointType.ACCESS;
    }




    public String getUserAgent(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("User-Agent");
    }

    public String getIpAddress(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRemoteAddr();
    }

    public String getJwtTokenIfExist(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }


}
