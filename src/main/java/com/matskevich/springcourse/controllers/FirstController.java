package com.matskevich.springcourse.controllers;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("calculator")
    public String calculate(@RequestParam(value = "a", required = false) Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "action", required = false) String action, Model model) {
        if (a != null && b != null && action != null) {
            if (action.equals("addition")) {
                model.addAttribute("result", a + b);
                System.out.println(a + b);
            } else if (action.equals("subtraction"))
                model.addAttribute("result", a - b);
            else if (action.equals("multiplication"))
                model.addAttribute("result", a * b);
            else if (action.equals("division") & b != 0)
                model.addAttribute("result", a / b);
        }
        return "first/calculator";
    }
}
