package com.service.microservice.dao;

import com.service.microservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int save(UUID id, Person person);

    default int save(Person person) {
        UUID id = UUID.randomUUID();
        return save(id, person);
    }

    List<Person> findAll();

    Optional<Person> findById(UUID id);

    int delete(UUID id);

    int updatePersonById(Person person);
}
