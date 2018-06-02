package com.andrgree.house.controller;

import com.andrgree.house.model.Appeal;
import com.andrgree.house.model.House;
import com.andrgree.house.proxy.AppealServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.profiles.active:none}")
    private String profile;

    @Autowired
    private AppealServiceProxy serviceProxy;

    @GetMapping("/")
    //@HystrixCommand(fallbackMethod = "defaultAppeal")
    public House main() {

        House house = new House("12");
        house.setProfile(profile);
        house.setAppeal(serviceProxy.getAppeal());
        return house;
    }

    public House defaultAppeal() {
        return  new House("none");
    }
}
