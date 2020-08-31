package com.erik.personapi.service;

import com.erik.personapi.dto.request.PersonDTO;
import com.erik.personapi.dto.response.MessageResponseDTO;
import com.erik.personapi.entity.Person;
import com.erik.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.erik.personapi.utils.PersonUtils.createFakeDTO;
import static com.erik.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testeGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSucessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO sucesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage, sucesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id){
        return MessageResponseDTO
                .builder()
                .message("Createad person with ID " + id)
                .build();
    }
}
