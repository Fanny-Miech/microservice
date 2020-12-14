//package com.service.microservice.api;
//
//import com.service.microservice.dao.PersonDao;
//import com.service.microservice.model.Person;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Objects;
//import java.util.UUID;
//
////@Api("API pour les opérations CRUD sur les personnages")
//@RequestMapping("api/person")
//@RestController
//public class PersonController3 {
//
//    private PersonDao personDao;
//
//    @Autowired
//    public PersonController3(PersonDao personService) {
//        this.personDao = personService;
//    }
//
//    @ApiOperation(value="Créer un nouveau personnage")
//    @PostMapping
//    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
//        personDao.save(person);
//        if (person == null)
//            return ResponseEntity.noContent().build();
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(person.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @ApiOperation(value="Afficher tous les personnages")
//    @GetMapping
//    public ResponseEntity<List<Person>> getAllPeople() {
//            return ResponseEntity.ok(personDao.findAll());
//    }
//
//    @ApiOperation(value="Afficher un personnage grâce à son id")
//    @GetMapping(path = "{id}")
//    public ResponseEntity<Person> getPersonById(@PathVariable("id") UUID id) {
//        return ResponseEntity.ok(Objects.requireNonNull(personDao.findById(id)
//                .orElse(null)));
//    }
//
//    @ApiOperation(value="Supprimer un personnage grâce à son id")
//    @DeleteMapping(path = "{id}")
//    public ResponseEntity<Void> deletePersonById(@PathVariable("id") UUID id) {
//        personDao.delete(id);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value="Modifier un personnage")
//    @PutMapping
//    public ResponseEntity<Void> updatePerson(@RequestBody Person personToUpdate) {
//        personDao.updatePersonById(personToUpdate);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//}
