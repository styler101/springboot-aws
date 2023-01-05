package com.webservices_with_aws.webservicewithaws.services;

import com.webservices_with_aws.webservicewithaws.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

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
        List<Person> persons = new ArrayList<Person>();
        for(int i = 0; i < 8; i++){

            Person person = mockPerson((long) i);
            persons.add(person);
        }
        return persons;
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