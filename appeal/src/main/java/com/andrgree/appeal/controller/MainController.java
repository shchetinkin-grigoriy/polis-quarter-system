package com.andrgree.appeal.controller;

import com.andrgree.appeal.model.Appeal;
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
    public Appeal main() {
        Appeal house = new Appeal("12");
        return house;
    }
}
