package com.service.microservice.api;

import com.service.microservice.model.Person;
import com.service.microservice.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
public class PersonController2 {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        personRepository.save(person);
        if (person == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public Iterable<Person> getAllPerson() {

        return personRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPerson(@PathVariable Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person;
    }

    @PutMapping
    public String updatePerson(@RequestBody Person person) {
        personRepository.save(person);
        return "Updated";
    }

    @DeleteMapping(path = "{id}")
    public String deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
        return "Deleted";
    }
}
