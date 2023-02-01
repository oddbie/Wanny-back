package com.oddbie.wannyback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
// @RequestMapping("/api")
@Slf4j
public class HelloController {
    @GetMapping("/api/hello")
    public String Hello() {
        log.info("hello api called");
        return "Hello from Spring\n";
    }
}
