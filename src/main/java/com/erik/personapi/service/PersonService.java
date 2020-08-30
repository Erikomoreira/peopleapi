package com.erik.personapi.service;

import com.erik.personapi.dto.request.PersonDTO;
import com.erik.personapi.dto.response.MessageResponseDTO;
import com.erik.personapi.entity.Person;
import com.erik.personapi.mapper.PersonMapper;
import com.erik.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson  = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Createad person with ID " + savedPerson.getId())
                .build();
    }

    //Aula 9
    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
        }
}
