package com.andrgree.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }

}
