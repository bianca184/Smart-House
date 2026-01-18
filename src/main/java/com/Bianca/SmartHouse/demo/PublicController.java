package com.Bianca.SmartHouse.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/home")
    public String home() {
        return "Welcome to SmartHouse! Please register or login.";
    }
}
