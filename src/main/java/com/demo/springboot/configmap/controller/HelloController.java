package com.demo.springboot.configmap.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msgs")
public class HelloController {

    @Value("${greeter.message}")
    private String greeterMessageFormat;

    @GetMapping("{msg}")
    public ResponseEntity getMessage(@PathVariable("msg") String msg){
        System.out.println("Msg : " + msg);
        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        System.out.println("Prefix : " + prefix + " and User: " +  user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format(greeterMessageFormat, prefix, user);
    }
}
