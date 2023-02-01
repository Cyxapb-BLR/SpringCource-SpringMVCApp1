package com.matskevich.springcourse.controllers;

import com.matskevich.springcourse.dao.PersonDAO;
import com.matskevich.springcourse.models.Person;
import com.matskevich.springcourse.services.ItemService;
import com.matskevich.springcourse.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;
    private final PersonDAO personDAO;
    private final ItemService itemService;

    @Autowired
    public PeopleController(PeopleService peopleService, PersonDAO personDAO, ItemService itemService) {
        this.peopleService = peopleService;
        this.personDAO = personDAO;
        this.itemService = itemService;
    }

    @GetMapping()
    public String index(Model model) {
        // get all people from DAO and sent them to View
       /* model.addAttribute("people", peopleService.findAll());

        itemService.findByItemName("Airpods");
        itemService.findByOwner(peopleService.findAll().get(0));

        peopleService.test();*/

        personDAO.TestNPlus1();

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //get 1 person from DAO by id and sent it to View
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}
