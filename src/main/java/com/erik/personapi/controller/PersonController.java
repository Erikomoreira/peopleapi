package com.erik.personapi.controller;

import com.erik.personapi.dto.MessageResponseDTO;
import com.erik.personapi.entity.Person;
import com.erik.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return  personService.createPerson(person);
    }

}
