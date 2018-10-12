package com.andrgree.house.service;

import com.andrgree.house.model.House;

import java.util.List;

public interface HouseService {

    House getHouseById(Long id);

    House createHouse(Long id, String name, String profile);

    List<House> getFindAll();
}
