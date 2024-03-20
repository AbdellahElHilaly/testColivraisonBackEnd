package com.abdellah.colivraison.security.common.principal;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.security.common.helper.AuthoritiesHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserPrincipal extends User implements UserDetails {

    @JsonIgnore
    private final AuthoritiesHelper authoritiesHelper;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authoritiesHelper.getAuthoritiesByRole(this.getRole());
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public void setUser(@NotNull User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRole(user.getRole());
    }
}
