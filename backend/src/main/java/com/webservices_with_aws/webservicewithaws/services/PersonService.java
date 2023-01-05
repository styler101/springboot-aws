package com.webservices_with_aws.webservicewithaws.services;

import com.webservices_with_aws.webservicewithaws.entities.Person;
import com.webservices_with_aws.webservicewithaws.exceptions.RessourceNotFoundException;
import com.webservices_with_aws.webservicewithaws.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());
    List<Person> persons = new ArrayList<Person>();
    public Person findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("No data found for this ID"));
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("Create one Person!");
        return repository.save(person);

    }

    public Person update( Person person){
       logger.info("Create one Person!");
       Person entity = repository.findById(person.getId()).orElseThrow(() -> new RessourceNotFoundException("No recors found for this ID"));
       entity.setFirstName(person.getFirstName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());
       entity.setLastName(person.getLastName());
       return repository.save(person);
    }

    public void delete(Long id){
       Person entity = repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Id not found"));
       repository.delete(entity);
    }





}

// entity -> dto -> controller -> service -> repositório