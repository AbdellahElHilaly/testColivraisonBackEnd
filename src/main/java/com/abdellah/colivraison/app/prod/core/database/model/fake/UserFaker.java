package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
@RequiredArgsConstructor
public class UserFaker implements ModelFaker<User>{
    private final PasswordEncoder passwordEncoder;
    List<User> UserList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public User generate() {
        return User.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .password(passwordEncoder.encode(faker.internet().password()))
                .build();
    }

    public List<User> generateList(int size) {
        UserList.clear();
        UserList.add(generateFakeAdmin());
        UserList.add(generateFakeVendor());
        for (int i = 0; i < size; i++) {
            UserList.add(generate());
        }
        return UserList;
    }

    private User generateFakeAdmin() {
        return User.builder()
                .name("fake admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("@admin1234"))
                .build();
    }

    private User generateFakeVendor() {
        return User.builder()
                .name("fake vendor")
                .email("vendor@gmail.com")
                .password(passwordEncoder.encode("@vendor1234"))
                .build();
    }


}
