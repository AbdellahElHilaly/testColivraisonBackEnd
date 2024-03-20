package com.abdellah.colivraison.security.common.helper;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Privilege;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthoritiesHelper {

    public Collection<? extends GrantedAuthority> getAuthoritiesByRole(Role role) {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        for (Privilege privilege : role.getPrivileges()) {
            authorities.add(new SimpleGrantedAuthority(privilege.getName()));
        }
        return authorities;

    }


}
