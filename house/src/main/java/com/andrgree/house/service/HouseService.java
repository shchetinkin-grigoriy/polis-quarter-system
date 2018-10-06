package com.andrgree.house.service;

import com.andrgree.house.model.House;

public interface HouseService {

    House getHouseById(Long id);

    House createHouse(Long id, String name, String profile);
}
