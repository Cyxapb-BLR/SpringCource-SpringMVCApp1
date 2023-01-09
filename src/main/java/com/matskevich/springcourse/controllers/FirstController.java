package com.matskevich.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("first")
public class FirstController {
    @GetMapping("hello")
    public String helloPage(@RequestParam("firstname") String firstName,
                            @RequestParam("lastname") String lastName) {
        System.out.println("Hello, " + firstName + " " + lastName);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
