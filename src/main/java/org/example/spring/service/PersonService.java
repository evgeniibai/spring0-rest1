package org.example.spring.service;

import org.example.spring.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person getOne(long id);

    Person savePerson(Person person);

    void deletePerson(long id);
}
