package com.webservices_with_aws.webservicewithaws;


import com.webservices_with_aws.webservicewithaws.entities.Person;
import com.webservices_with_aws.webservicewithaws.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(value = "/persons")
public class PersonController {

   @Autowired
   private PersonService service;
   private final AtomicLong counter = new AtomicLong();

   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Person> findAll(){
     return service.findAll();
   }
   @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public Person findById(@PathVariable(value="id") Long id){
      return service.findById(id);
   }

   @RequestMapping(method = RequestMethod.PUT,
           produces = MediaType.APPLICATION_JSON_VALUE,
           consumes = MediaType.APPLICATION_JSON_VALUE
   )
   public Person create(@RequestBody Person person){
      return service.create(person);
   }

   @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
   public void delete(@PathVariable (value = "id") Long id){
      service.delete(id);
   }


}
