package com.abdellah.colivraison.security.utils.env;

import com.abdellah.colivraison.security.utils.enums.TokenType;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
@Getter
public class SecurityEnvironment {

    public Date getTokenExpirationDate(TokenType tokenType) {
        if (tokenType == null) {
            throw new RuntimeException("Token type is required");
        } else if (tokenType == TokenType.ACCESS_TOKEN) {
            return getAccessTokenExpirationDate();
        } else {
            return getRefreshTokenExpirationDate();
        }
    }

    private Date getRefreshTokenExpirationDate() {
        return Date.from(Instant.now().plus(7, ChronoUnit.DAYS));
    }

    private Date getAccessTokenExpirationDate() {
        return Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
    }
}
