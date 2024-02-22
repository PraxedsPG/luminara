package com.br.dev.luminara.dto.person;

import com.br.dev.luminara.dto.address.AddressData;

public record UpdatePersonData(Long id, String firstName, String lastName, AddressData address) {

}
