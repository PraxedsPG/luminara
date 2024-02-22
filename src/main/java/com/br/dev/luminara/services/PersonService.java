package com.br.dev.luminara.services;

import com.br.dev.luminara.dto.person.DetailsPersonData;
import com.br.dev.luminara.dto.person.PersonData;
import com.br.dev.luminara.dto.person.PersonListeningData;
import com.br.dev.luminara.dto.person.UpdatePersonData;
import com.br.dev.luminara.model.Person;
import com.br.dev.luminara.repositories.PersonRepository;
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
public class PersonService {

    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person createPerson(PersonData data) {
        logger.info("Creating a person!");
        var person = new Person(data);
        return repository.save(person);
   }

   public ResponseEntity<List<PersonListeningData>> listAll(Pageable pagination) {
        logger.info("Listening all persons!");
        List<PersonListeningData> personList = repository.findAll(pagination)
                .stream().map(PersonListeningData::new).collect(Collectors.toList());
        return new ResponseEntity<>(personList, HttpStatus.OK);
   }

    public ResponseEntity findBySearch(Long id) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            logger.info("Finding a person!");
            Person person = personOptional.get();
            return ResponseEntity.ok(new DetailsPersonData(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity updatePerson(UpdatePersonData data) {
        Optional<Person> personOptional = repository.findById(data.id());
        if (personOptional.isPresent()) {
            logger.info("Uploading a person!");
            Person person = personOptional.get();
            person.updateInformation(data);
            repository.save(person);
            return ResponseEntity.ok(new DetailsPersonData(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity deletePerson(Long id) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            logger.info("Deleting a person from your system!");
            Person person = personOptional.get();
            repository.delete(person);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



