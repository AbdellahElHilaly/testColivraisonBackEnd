package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.ColisPhone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
public class ColisPhoneFaker implements ModelFaker<ColisPhone>{
    List<ColisPhone> ColisPhoneList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public ColisPhone generate() {
        return ColisPhone.builder()
                .number(faker.phoneNumber().phoneNumber())
                .build();
    }

    public List<ColisPhone> generateList(int size) {
        ColisPhoneList.clear();
        for (int i = 0; i < size; i++) {
            ColisPhoneList.add(generate());
        }
        return ColisPhoneList;
    }


}
