package com.br.dev.luminara.controllers;

import com.br.dev.luminara.dto.person.DetailsPersonData;
import com.br.dev.luminara.dto.person.PersonData;
import com.br.dev.luminara.dto.person.UpdatePersonData;
import com.br.dev.luminara.model.Person;
import com.br.dev.luminara.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<DetailsPersonData> create(@RequestBody PersonData data, UriComponentsBuilder uriBuilder) throws Exception {
        Person person = service.createPerson(data);
        var uri = uriBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsPersonData(person));
    }
    @GetMapping
    public ResponseEntity listAll(@PageableDefault(size = 10, sort = {"firstName"}) Pageable pagination) {
       return service.listAll(pagination);
    }

    @GetMapping("{id}")
    public ResponseEntity Search(@PathVariable Long id) {
        return service.findBySearch(id);
    }

    @PutMapping()
    public ResponseEntity updatePerson(@RequestBody UpdatePersonData data) {
        return service.updatePerson(data);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }

}
