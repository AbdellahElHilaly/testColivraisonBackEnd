package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;


@Component
public class RoleFaker implements ModelFaker<Role>{
    List<Role> RoleList = new ArrayList<>();
    Faker faker = Faker.instance();

    public List<Role> generateStaticList() {

        if (!RoleList.isEmpty()) return RoleList;

        RoleList.add(Role.builder().name("ADMIN").build());
        RoleList.add(Role.builder().name("VENDOR").build());
        RoleList.add(Role.builder().name("LIVREUR").build());
        RoleList.add(Role.builder().name("STOCK_MANAGER").build());
        return RoleList;

    }

    @Override
    public Role generate() {
        return Role.builder()
                .name(faker.name().name())
                .build();
    }

    @Override
    public List<Role> generateList(int size) {
       return generateStaticList();
    }


    public Role generateStatic() {
        Random random = new Random();
        return generateStaticList().get(random.nextInt(RoleList.size()));
    }
}
