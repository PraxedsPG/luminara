package com.br.dev.luminara.dto.person;

import com.br.dev.luminara.dto.address.AddressData;

public record PersonData(String firstName, String lastName, String birthdayDate, AddressData address) {
}
