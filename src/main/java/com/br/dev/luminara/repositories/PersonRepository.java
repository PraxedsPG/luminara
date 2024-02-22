package com.br.dev.luminara.repositories;


import com.br.dev.luminara.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Page<Person> findAll(Pageable pagination);
}
