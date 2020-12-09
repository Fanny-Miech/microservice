package com.service.microservice.api;

import com.service.microservice.model.Person;
import com.service.microservice.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Api(description="API pour les opérations CRUD sur les personnages")
@RequestMapping("api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value="Créer un nouveau personnage")
    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        if (person == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value="Afficher tous les personnages")
    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
            return ResponseEntity.ok(personService.getAllPeople());
    }

    @ApiOperation(value="Afficher un personnage grâce à son id")
    @GetMapping(path = "{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(Objects.requireNonNull(personService.getPersonById(id)
                .orElse(null)));
    }

    @ApiOperation(value="Supprimer un personnage grâce à son id")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable("id") UUID id) {
       personService.deletePerson(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value="Modifier un personnage")
    @PutMapping
    public ResponseEntity<Void> updatePerson(@RequestBody Person personToUpdate) {
        personService.updatePerson(personToUpdate);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
