package com.example.assecor.controller;

import com.example.assecor.persistence.PersonEntity;
import com.example.assecor.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonRestController {
    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    @ResponseBody
    public List<PersonEntity> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    @ResponseBody
    public PersonEntity getPerson(@PathVariable String id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(Long.parseLong(id));
        if(personEntityOptional.isPresent()){
            return personEntityOptional.get();
        }
        return null;
    }

    @GetMapping("/persons/color/{colorId}")
    @ResponseBody
    public List<PersonEntity> getPersonsByColor(@PathVariable String colorId) {
        return (List<PersonEntity>) personRepository.findByColorId(Long.valueOf(colorId));
    }

    @PostMapping("/savePerson")
    void addPerson(@RequestBody PersonEntity person) {
        personRepository.save(person);
    }
}
