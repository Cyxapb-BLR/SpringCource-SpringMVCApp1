package com.matskevich.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HelloController {
    @GetMapping("hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
