package com.andrgree.house.service;

import com.andrgree.house.model.House;
import com.andrgree.house.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository repository;

    @Override
    public House getHouseById(Long id) {
        //return new House("12");
        return repository.getOne(id);
    }

    @Override
    public House createHouse(Long id, String name, String profile) {
        House house = new House(name);
        house.setId(id);
        house.setProfile(profile);
        return repository.saveAndFlush(house);
    }
}
