package com.webservices_with_aws.webservicewithaws.controllers;


import com.webservices_with_aws.webservicewithaws.data.vo.v1.PersonVO;
import com.webservices_with_aws.webservicewithaws.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/persons")
public class PersonController {

   @Autowired
   private PersonService service;

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public List<PersonVO> findAll(){
     return service.findAll();
   }
   @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public PersonVO findById(@PathVariable(value="id") Long id){
      return service.findById(id);
   }

  @PostMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
   public PersonVO create(@RequestBody PersonVO person){
      return service.create(person);
   }
   @PutMapping(value="/{id}")
   public PersonVO update(@PathVariable(value="id") Long id , @RequestBody PersonVO person) {
       return service.update(id,person);
   }
   @DeleteMapping(value="/{id}")
   public ResponseEntity<?> delete(@PathVariable (value = "id") Long id){
       service.delete(id);
       return ResponseEntity.noContent().build();


   }


}
