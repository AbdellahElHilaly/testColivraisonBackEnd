package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.UserPhone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
public class UserPhoneFaker implements ModelFaker<UserPhone>{
    List<UserPhone> userPhoneList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public UserPhone generate() {
        return UserPhone.builder()
                .number(faker.phoneNumber().phoneNumber())
                .build();
    }

    public List<UserPhone> generateList(int size) {
        userPhoneList.clear();
        for (int i = 0; i < size; i++) {
            userPhoneList.add(generate());
        }
        return userPhoneList;
    }


}
