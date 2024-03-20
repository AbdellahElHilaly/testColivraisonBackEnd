package com.abdellah.colivraison.app.prod.core.database.model.fake;

import com.abdellah.colivraison.app.prod.core.database.model.entity.Role;

import java.util.List;

public interface ModelFaker <T>{
    T generate();
    List<T> generateList(int size);

}
