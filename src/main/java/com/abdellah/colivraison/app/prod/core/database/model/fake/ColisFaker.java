package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Colis;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColisFaker implements ModelFaker<Colis> {
    List<Colis> colisList = new ArrayList<>();
    Faker faker = Faker.instance();

    @Override
    public Colis generate() {
        return Colis.builder()

                .colisOfStock(faker.bool().bool())
                .colisOfReplacement(faker.bool().bool())
                .fragile(faker.bool().bool())
                .openable(faker.bool().bool())

                .suiviCode(faker.code().asin())
                .adresse(faker.address().fullAddress())
                .price(faker.number().randomDouble(2, 0, 1000))
                .destinataire(faker.name().fullName())
                .marchandise(faker.commerce().productName())
                .quantity(faker.number().randomDigitNotZero())

                .ramassageDate(faker.date().birthday())
                .putInStockDate(faker.date().birthday())
                .shippingDate(faker.date().birthday())
                .deliveryDate(faker.date().birthday())

                .build();
    }

    public List<Colis> generateList(int size) {
        colisList.clear();
        for (int i = 0; i < size; i++) {
            colisList.add(generate());
        }
        return colisList;
    }
}
