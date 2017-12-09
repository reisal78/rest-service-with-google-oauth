package ru.reisal7i.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ProtectedController {

    @GetMapping("/profile")
    public String get(Principal principal) {
        String resp = principal != null ? principal.getName() : "Anonymous";
        return "Hello, " + resp;
    }

}
