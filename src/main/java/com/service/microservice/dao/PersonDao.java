//package com.service.microservice.dao;
//
//import com.service.microservice.model.Person;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public interface PersonDao extends JpaRepository<Person, UUID> {
//    int save(UUID id, Person person);
//
//    default int save(Person person) {
//        UUID id = UUID.randomUUID();
//        return save(id, person);
//    }
//
//    List<Person> findAll();
//
//    Optional<Person> findById(UUID id);
//
//    int delete(UUID id);
//
//    int updatePersonById(Person person);
//}
