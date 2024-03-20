package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Status;
import com.abdellah.colivraison.app.prod.core.database.model.enums.StatusEnum;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StatusFaker implements ModelFaker<Status> {
    List<Status> statusList = new ArrayList<>();
    Faker faker = Faker.instance();


    @Override
    public Status generate() {
        return Status.builder()
                .name(faker.name().name())
                .build();
    }

    public List<Status> generateList(int size) {
        statusList.clear();

        for (StatusEnum statusEnum : StatusEnum.values()) {
            statusList.add(Status.builder().name(statusEnum.name()).build());
        }

        for (int i = 0; i < size; i++) {
            statusList.add(generate());
        }

        return statusList;
    }


}
