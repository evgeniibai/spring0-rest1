package org.example.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.exception.PersonNotFoundException;
import org.example.spring.model.Person;
import org.example.spring.repository.PersonRepository;
import org.example.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAllPersons() {
        log.info("getAllPersons: {} persons found!", repository.findAll().size());
        return repository.findAll();
    }

    @Override
    public Person getOne(long personId) {
        log.info("getOne: get person by ID: {}", personId);
        return repository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person with ID: " + personId + " not found!"));
    }

    @Override
    public Person savePerson(Person person) {
        log.info("savePerson: save {} in db", person);
        repository.save(person);
        return person;
    }

    @Override
    public Person updatePerson(long personId, Person person) {
        log.info("updatePerson setting id {} at Request person", personId);
        person.setId(personId);
        log.info("updatePerson save {} in db", person);
        return repository.save(person);
    }

    @Override
    public String deletePerson(long personId) {
        log.info("deletePerson: delete person from db with ID: {}", personId);
        repository.deleteById(personId);
        return "Deleted!";
    }
}
