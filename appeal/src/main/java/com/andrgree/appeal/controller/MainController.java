package com.andrgree.appeal.controller;

import com.andrgree.appeal.model.Appeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/")
    public Appeal main() {
        logger.info("MainController run");
        Appeal house = new Appeal();
        house.setName("asd");
        return house;
    }
}
