package org.example.spring.service;

import org.example.spring.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person getOne(long personId);

    Person savePerson(Person person);

    Person updatePerson(long personId, Person person);

    String deletePerson(long personId);
}
