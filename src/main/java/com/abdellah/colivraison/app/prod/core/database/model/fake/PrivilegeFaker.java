package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import com.abdellah.colivraison.app.prod.core.database.model.entity.enums.Privilege;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;


@Component
public class PrivilegeFaker implements ModelFaker<Privilege> {
    List<Privilege> PrivilegeList = new ArrayList<>();
    Faker faker = Faker.instance();

    private List<Privilege> generateStaticList() {
        if(!PrivilegeList.isEmpty()) return PrivilegeList;
        PrivilegeList.add(Privilege.builder().name("CAN_PICKUP").build());
        return PrivilegeList;


    }

    @Override
    public Privilege generate() {
        return Privilege.builder()
                .name(faker.name().name())
                .build();
    }

    public List<Privilege> generateList(int size) {
        return generateStaticList();
    }


}
