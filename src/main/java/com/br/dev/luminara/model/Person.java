package com.br.dev.luminara.model;

import com.br.dev.luminara.dto.person.PersonData;
import com.br.dev.luminara.dto.person.UpdatePersonData;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday_date")
    private String birthdayDate;

    @Embedded
    private Address address;

    public Person (PersonData data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.birthdayDate = data.birthdayDate();
        this.address = new Address(data.address());
    }

    public void updateInformation(UpdatePersonData data) {
        if((data.firstName()) != null) {
            this.firstName = data.firstName();
        }
        if (data.lastName() != null) {
            this.lastName = data.lastName();
        }
        if(data.address() != null) {
            this.address.updateAddressInformation(data.address());
        }
    }

}
