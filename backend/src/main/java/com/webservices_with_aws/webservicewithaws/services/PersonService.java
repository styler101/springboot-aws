package com.webservices_with_aws.webservicewithaws.services;

import com.webservices_with_aws.webservicewithaws.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    List<Person> persons = new ArrayList<Person>();
    public Person findById(String id){
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Lucas");
        person.setGender("Male");
        person.setLastName("Santos");
        person.setAddress("Belo Uberlândia - Minas Gerais");
        return person;
    }

    public List<Person> findAll(){

        for(int i = 0; i < 8; i++){

            Person person = mockPerson((long) i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person){
        logger.info("Create one Person!");
        return person;
    }

    public Person update(Person person){
        logger.info("Create one Person!");
        return person;
    }

    public void delete(String id){
        persons.stream().filter((x) -> x.getId() != Long.parseLong(id)).collect(Collectors.toList());
    }

    private Person mockPerson(Long i){
        Person person = new Person();
        person.setId(i);
        person.setFirstName("Person name" + counter.getAndIncrement());
        person.setGender("Last Name" + counter.getAndIncrement());
        person.setLastName("Santos");
        person.setAddress("Belo Uberlândia - Minas Gerais");
        return  person;
    }

}

// entity -> dto -> controller -> service -> repositório