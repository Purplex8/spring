package com.merio.spring.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookApiController {
    @GetMapping("/")
    public String ok() {
        return "ok";
    }
}
