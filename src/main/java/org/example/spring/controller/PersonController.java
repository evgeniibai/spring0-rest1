package org.example.spring.controller;

import org.example.spring.model.Person;
import org.example.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public String showAllPeople(Model model) {
        List<Person> people = service.getAllPersons();
        model.addAttribute("people", people);
        return "people";
    }
}
