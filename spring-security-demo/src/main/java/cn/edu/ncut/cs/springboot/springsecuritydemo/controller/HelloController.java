package cn.edu.ncut.cs.springboot.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello") // http://localhost:8080/hello
    public String hello() {
        return "Hello Spring Security!";
    }
}