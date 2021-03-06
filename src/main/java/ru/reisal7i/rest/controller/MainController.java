package ru.reisal7i.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String root() {
        return "Hello world";
    }

    @GetMapping("/google/login")
    public String login(@RequestParam (value = "code") String code) {
        return "Code =  " + code;
    }

}
