package com.andrgree.house.controller;

import com.andrgree.house.model.House;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MainController {

    @Value("${spring.profiles.active:none}")
    private String profile;

    @GetMapping("/")
    public House main() {
        House house = new House("12");
        house.setProfile(profile);
        return house;
    }
}
