package com.spring.security.homeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/"})
    public String welcomePage() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping({"/user"})
    public String userPage() {
        return "<h1>Welcome User</h1>";
    }

    @GetMapping({"/admin"})
    public String adminPage() {
        return "<h1>Welcome Admin</h1>";
    }
}
