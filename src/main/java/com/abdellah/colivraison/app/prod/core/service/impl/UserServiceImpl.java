package com.abdellah.colivraison.app.prod.core.service.impl;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import com.abdellah.colivraison.app.prod.core.database.repository.UserRepository;
import com.abdellah.colivraison.app.prod.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User not found with email : " + username));
    }

    @Override
    public Role getRoleByEmail(String email) {
        return userRepository.getRoleByUserEmail(email);
    }

    @Override
    public String getUserNameByEmail(String email) {
        return userRepository.getUserNameByEmail(email);
    }


}
