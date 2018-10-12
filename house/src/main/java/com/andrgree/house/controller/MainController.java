package com.andrgree.house.controller;

import com.andrgree.house.model.House;
import com.andrgree.house.proxy.AppealServiceProxy;
import com.andrgree.house.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.profiles.active:none}")
    private String profile;

    @Autowired
    private AppealServiceProxy serviceProxy;

    @Autowired
    private HouseService houseService;

    @GetMapping("/")
    //@HystrixCommand(fallbackMethod = "defaultAppeal")
    public House main() {
        //House house = new House("12");
        House house = houseService.getHouseById(1L);
        house.setProfile(profile);
        house.setAppeal(serviceProxy.getAppeal());
        return house;
    }

    @GetMapping("/all")
    //@HystrixCommand(fallbackMethod = "defaultAppeal")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<House> all() {
        //House house = new House("12");
        List<House> houses = houseService.getFindAll();
        return houses;
    }

    public House defaultAppeal() {
        return  new House("none");
    }
}
