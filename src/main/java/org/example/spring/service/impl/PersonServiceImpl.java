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
    public Person getOne(long id) {
        log.info("getOne: get person by ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with ID: " + id + " not found!"));
    }

    @Override
    public Person savePerson(Person person) {
        log.info("savePerson: save {} in db", person);
        repository.save(person);
        return person;
    }

    @Override
    public void deletePerson(long id) {
        log.info("deletePerson: delete person from db with ID: {}", id);
        repository.deleteById(id);
    }
}
