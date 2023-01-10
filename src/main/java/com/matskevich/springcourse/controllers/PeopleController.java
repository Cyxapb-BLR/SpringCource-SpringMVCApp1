package com.matskevich.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @GetMapping()
    public String index(Model model) {
        // get all people from DAO and sent them to View
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //get 1 person from DAO by id and sent it to View
        return null;
    }
}
