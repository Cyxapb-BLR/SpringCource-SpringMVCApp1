package com.matskevich.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("first")
public class FirstController {
    @GetMapping("hello")
    public String helloPage(HttpServletRequest request) {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        System.out.println("Hello, " + firstName + " " + lastName);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
