package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Zone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
public class ZoneFaker implements ModelFaker<Zone>{
    List<Zone> ZoneList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public Zone generate() {
        return Zone.builder()
                .name(faker.address().city())
                .build();
    }

    public List<Zone> generateList(int size) {
        ZoneList.clear();
        for (int i = 0; i < size; i++) {
            ZoneList.add(generate());
        }
        return ZoneList;
    }


}
