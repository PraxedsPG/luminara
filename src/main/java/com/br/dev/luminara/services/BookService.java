package com.br.dev.luminara.services;

import com.br.dev.luminara.dto.book.BookData;
import com.br.dev.luminara.dto.book.BookListeningData;
import com.br.dev.luminara.dto.book.DetailsBookData;
import com.br.dev.luminara.dto.book.UpdateBookData;
import com.br.dev.luminara.model.Book;
import com.br.dev.luminara.repositories.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRespository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Book createBook(BookData data) {
        logger.info("Creating a book!");
        var book = new Book(data);
        return repository.save(book);
    }

    public ResponseEntity<List<BookListeningData>> listAll(Pageable pagination) {
        logger.info("Listening all persons!");
        List<BookListeningData> bookList = repository.findAll(pagination)
                .stream().map(BookListeningData::new).collect(Collectors.toList());
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    public ResponseEntity findBySearch(Long id) {
        Optional<Book> bookOptional = repository.findById(id);
        if (bookOptional.isPresent()) {
            logger.info("Finding a book!");
            Book book = bookOptional.get();
            return ResponseEntity.ok(new DetailsBookData(book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity updatebook(UpdateBookData data) {
        Optional<Book> bookOptional = repository.findById(data.id());
        if (bookOptional.isPresent()) {
            logger.info("Uploading a book!");
            Book book = bookOptional.get();
            book.updateInformationBook(data);
            repository.save(book);
            return ResponseEntity.ok(new DetailsBookData(book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity deleteBook(Long id) {
        Optional<Book> bookOptional = repository.findById(id);
        if (bookOptional.isPresent()) {
            logger.info("Deleting a book from your system!");
            Book book = bookOptional.get();
            repository.delete(book);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
