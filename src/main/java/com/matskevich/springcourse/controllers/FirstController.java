package com.matskevich.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("first")
public class FirstController {
    @GetMapping("hello")
    public String helloPage(@RequestParam(value = "firstname", required = false) String firstName,
                            @RequestParam(value = "lastname", required = false) String lastName, Model model) {
        //System.out.println("Hello, " + firstName + " " + lastName);
        model.addAttribute("message", "Hello, " + firstName + " " + lastName);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
