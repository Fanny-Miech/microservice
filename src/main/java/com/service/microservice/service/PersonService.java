package com.service.microservice.service;

import com.service.microservice.dao.PersonDao;
import com.service.microservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person) {
        return personDao.save(person);
    }

    public List<Person> getAllPeople() {
        return personDao.findAll();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.findById(id);
    }


    public int deletePerson(UUID id) {
        return personDao.delete(id);
    }

    public int updatePerson(Person newPerson) {
        return personDao.updatePersonById(newPerson);
    }
}
