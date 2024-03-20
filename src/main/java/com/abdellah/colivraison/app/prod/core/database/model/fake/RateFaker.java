package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Rate;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RateFaker implements ModelFaker<Rate> {
    private final Faker faker = Faker.instance();
    private final List<Rate> rateList = new ArrayList<>();

    @Override
    public Rate generate() {
        return Rate.builder()
                .rate(faker.number().randomDouble(1, 10, 300))
                .build();
    }

    @Override
    public List<Rate> generateList(int size) {
        rateList.clear();
        for (int i = 0; i < size; i++) {
            rateList.add(generate());
        }
        return rateList;
    }
}
