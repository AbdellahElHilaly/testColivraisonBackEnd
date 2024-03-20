package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;


@Component
public class CityFaker implements ModelFaker<City>{
    List<City> cityList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public City generate() {
        return City.builder()
                .name(faker.address().cityName())
                .build();
    }

    public List<City> generateList(int size) {
        cityList.clear();
        for (int i = 0; i < size; i++) {
            cityList.add(generate());
        }
        return cityList;
    }


}
