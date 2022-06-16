package org.example.spring.rest;

import org.example.spring.dto.PersonRequestDTO;
import org.example.spring.dto.PersonResponseDTO;
import org.example.spring.model.Person;
import org.example.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<PersonResponseDTO> showAllPeople() {
        List<Person> people = service.getAllPersons();
        return people.stream()
                .map(PersonResponseDTO::fromPerson)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{personId}")
    public PersonResponseDTO showOneById(@PathVariable long personId) {
        return PersonResponseDTO.fromPerson(service.getOne(personId));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person savePerson(@RequestBody PersonRequestDTO personDTO) {
        Person person = personDTO.toPerson();
        return service.savePerson(person);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{personId}")
    public Person updatePerson(@PathVariable long personId, @RequestBody PersonRequestDTO personDTO) {
        Person person = personDTO.toPerson();
        return service.updatePerson(personId, person);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{personId}")
    public String deletePerson(@PathVariable long personId) {
        return service.deletePerson(personId);
    }
}
