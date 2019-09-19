package com.aitlp.controller;

import com.aitlp.domain.Person;
import com.aitlp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/findByName")
    public List<Person> findByName(String name) {
        return personService.findByName(name);
    }

    @GetMapping("/findByConditions")
    public List<Person> findByConditions(Person person) {
        return personService.findByConditions(person);
    }

    @PostMapping("/save")
    public Map save(@RequestBody Person person) {
        return personService.save(person);
    }

    @DeleteMapping("/delete")
    public Map delete(@RequestBody Person person) {
        return personService.delete(person);
    }
}
