package com.webservices_with_aws.webservicewithaws;

import com.webservices_with_aws.webservicewithaws.exceptions.UnsupportedMathOperationException;
import com.webservices_with_aws.webservicewithaws.handler.CustomizeResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {

   @RequestMapping(value="/sum/{number1}/{number2}", method = RequestMethod.GET)
   public double sum(@PathVariable(value = "number1") String numberOne,  @PathVariable(value="number2") String numberTwo) throws Exception{
      if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
         // devemos sempre retornar a classe de erro.
         throw  new UnsupportedMathOperationException("Please set a number on request param.");
      }
      return convertToDouble(numberOne) + convertToDouble(numberTwo);
   }


   private boolean isNumeric(String stringNumber){
      // verifca se o número é positivo ou negaitvo de 1 a 9 e possui casas decimais
      return stringNumber != null ?  stringNumber.matches("[-+]?[0-9]*\\.?[0-9]+"): false;
   }

   private double convertToDouble(String stringNumber){
      return stringNumber == null ? 0D : Double.parseDouble(stringNumber.replace(',', '.'));


   }




}
