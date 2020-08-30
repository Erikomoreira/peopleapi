package com.erik.personapi.service;

import com.erik.personapi.dto.MessageResponseDTO;
import com.erik.personapi.entity.Person;
import com.erik.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Createad person with ID " + savedPerson.getId())
                .build();
    }


}
