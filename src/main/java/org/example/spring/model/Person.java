package org.example.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Long id;

    @Column(name = "p_email", nullable = false, length = 100)
    private String email;

    @Column(name = "p_password", nullable = false)
    private String password;

    @Column(name = "p_first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "p_last_name", nullable = false, length = 100)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "p_role", length = 20, columnDefinition = "VARCHAR(20) default 'USER'")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "p_status", length = 20, columnDefinition = "VARCHAR(20) default 'ACTIVE'")
    private Status status;

    private Person(Builder builder) {
        this.email = Objects.requireNonNull(builder.email, "email");
        this.password = Objects.requireNonNull(builder.password, "password");
        this.firstName = Objects.requireNonNull(builder.firstName, "firstName");
        this.lastName = Objects.requireNonNull(builder.lastName, "lastName");
        this.role = Objects.requireNonNullElse(builder.role, Role.USER);
        this.status = Objects.requireNonNullElse(builder.status, Status.ACTIVE);
    }

    public static class Builder {
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private Role role;
        private Status status;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}