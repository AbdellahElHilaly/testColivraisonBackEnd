package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Etat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
public class EtatFaker implements ModelFaker<Etat>{
    List<Etat> EtatList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public Etat generate() {
        return Etat.builder()
                .name(faker.name().name())
                .build();
    }

    public List<Etat> generateList(int size) {
        EtatList.clear();
        for (int i = 0; i < size; i++) {
            EtatList.add(generate());
        }
        return EtatList;
    }


}
