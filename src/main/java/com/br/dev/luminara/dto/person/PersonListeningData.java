package com.br.dev.luminara.dto.person;

import com.br.dev.luminara.model.Address;
import com.br.dev.luminara.model.Person;

public record PersonListeningData(Long id, String firstName, String lastName, String birthdayDate, Address address) {
    public PersonListeningData(Person person) {
        this(person.getId(), person.getFirstName(), person.getLastName(), person.getBirthdayDate(), person.getAddress());
    }
}
