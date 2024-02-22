package com.br.dev.luminara.controllers;

import com.br.dev.luminara.dto.book.BookData;
import com.br.dev.luminara.dto.book.DetailsBookData;
import com.br.dev.luminara.dto.book.UpdateBookData;
import com.br.dev.luminara.dto.person.DetailsPersonData;
import com.br.dev.luminara.dto.person.PersonData;
import com.br.dev.luminara.dto.person.UpdatePersonData;
import com.br.dev.luminara.model.Book;
import com.br.dev.luminara.model.Person;
import com.br.dev.luminara.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<DetailsBookData> create(@RequestBody BookData data, UriComponentsBuilder uriBuilder) throws Exception {
        Book book = service.createBook(data);
        var uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsBookData(book));
    }

    @GetMapping
    public ResponseEntity listAll(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        return service.listAll(pagination);
    }

    @GetMapping("{id}")
    public ResponseEntity Search(@PathVariable Long id) {
        return service.findBySearch(id);
    }

    @PutMapping()
    public ResponseEntity updateBook(@RequestBody UpdateBookData data) {
        return service.updatebook(data);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        return service.deleteBook(id);
    }
}
