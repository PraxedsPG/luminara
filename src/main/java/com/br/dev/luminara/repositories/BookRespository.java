package com.br.dev.luminara.repositories;

import com.br.dev.luminara.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository  extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pagination);
}
