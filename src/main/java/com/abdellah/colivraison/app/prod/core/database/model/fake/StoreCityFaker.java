package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.StoreCity;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreCityFaker implements ModelFaker<StoreCity> {
    Faker faker = Faker.instance();
    List<StoreCity> storeCityList = new ArrayList<>();


    public List<StoreCity> generateStaticList() {
        if (!storeCityList.isEmpty()) return storeCityList;
        storeCityList.add(StoreCity.builder().villeName("Casablanca").build());
        return storeCityList;
    }


    @Override
    public StoreCity generate() {
        return null;
    }

    @Override
    public List<StoreCity> generateList(int size) {
        return null;
    }
}
