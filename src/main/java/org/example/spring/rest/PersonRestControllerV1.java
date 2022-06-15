package org.example.spring.rest;

import org.example.spring.dto.PersonInDTO;
import org.example.spring.dto.PersonOutDTO;
import org.example.spring.model.Person;
import org.example.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/people")
public class PersonRestControllerV1 {

    private final PersonService service;

    @Autowired
    public PersonRestControllerV1(PersonService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PersonOutDTO> showAllPeople() {
        List<Person> people = service.getAllPersons();
        return people.stream()
                .map(PersonOutDTO::fromPerson)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PersonOutDTO showOneById(@PathVariable long id) {
        return PersonOutDTO.fromPerson(service.getOne(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person savePerson(@Valid @RequestBody PersonInDTO personDTO) {
        Person person = personDTO.toPerson();
        return service.savePerson(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable long id) {
        service.deletePerson(id);
        //TODO dont return String- why?
        return "Deleted!";
    }
}
