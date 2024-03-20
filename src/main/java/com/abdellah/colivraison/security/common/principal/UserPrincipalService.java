package com.abdellah.colivraison.security.common.principal;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserPrincipalService implements UserDetailsService {

    private final UserService userService;
    private final UserPrincipal userPrincipal;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userPrincipal.setUser(userService.getUserByEmail(username));
        return  userPrincipal;
    }


    public UserPrincipal getUserPrincipalFromContextHolder() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserPrincipal) {
            return (UserPrincipal) principal;
        }
        return null;
    }

}
