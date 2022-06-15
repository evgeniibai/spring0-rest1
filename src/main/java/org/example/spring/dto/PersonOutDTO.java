package org.example.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import org.example.spring.model.Person;
import org.example.spring.model.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
public class PersonOutDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Status status;

    public static PersonOutDTO fromPerson(Person person) {
        return new PersonOutDTOBuilder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .status(person.getStatus())
                .build();
    }
}
