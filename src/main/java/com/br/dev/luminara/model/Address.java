package com.br.dev.luminara.model;

import com.br.dev.luminara.dto.address.AddressData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String street;
    @Column(name = "house_number")
    private String houseNumber;

    public Address(AddressData data) {
        this.country = data.country();
        this.city = data.city();
        this.street = data.street();
        this.houseNumber = data.houseNumber();
    }

    public void updateAddressInformation(AddressData data) {
        if((data.country()) != null) {
            this.country = data.country();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if(data.street() != null) {
            this.street = data.street();
        }
        if (data.houseNumber() != null) {
            this.houseNumber = data.houseNumber();
        }
    }

}
