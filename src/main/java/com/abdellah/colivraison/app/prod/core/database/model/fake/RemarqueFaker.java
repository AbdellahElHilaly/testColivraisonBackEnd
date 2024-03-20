package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Remarque;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemarqueFaker implements ModelFaker<Remarque> {
    private final Faker faker = Faker.instance();
    private final List<Remarque> RemarqueList = new ArrayList<>();

    @Override
    public Remarque generate() {
        return Remarque.builder()
                .content(faker.lorem().sentence())
                .build();
    }

    @Override
    public List<Remarque> generateList(int size) {
        RemarqueList.clear();
        for (int i = 0; i < size; i++) {
            RemarqueList.add(generate());
        }
        return RemarqueList;
    }
}
