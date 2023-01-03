package com.webservices_with_aws.webservicewithaws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class GrettingsController {

   private static final String template = "Hello, %s!";
   private static final String message = "A quantidade de usuários cadastrados foi %d";
   // mocka o id
   private final AtomicLong counter = new AtomicLong();


   @RequestMapping(value ="/greetings")
   public Grettings grettings(@RequestParam(value = "name", defaultValue ="world") String name){
       // para cada chamada ele vai incrementar e retonar
     return new Grettings(counter.incrementAndGet(), String.format(template, name));
   }

   @RequestMapping(value="/users")
      public String message(@RequestParam(value="quantity", defaultValue = "0") int quantity){
         return String.format(message, quantity);
      }

}
