package org.example.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.example.spring.model.Person;
import org.example.spring.model.Role;
import org.example.spring.model.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class PersonInDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;

    public Person toPerson() {
        return new Person.Builder()
                .email(getEmail())
                .password(getPassword())
                .firstName(getFirstName())
                .lastName(getLastName())
                .role(getRole())
                .status(getStatus())
                .build();
    }
}
