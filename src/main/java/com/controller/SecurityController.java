package com.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security/")
public class SecurityController {
    @GetMapping("say/hello")
    public void sayHello() {
        System.out.println("Hello, " + SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
