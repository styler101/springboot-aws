package com.webservices_with_aws.webservicewithaws;

import com.webservices_with_aws.webservicewithaws.exceptions.ExceptionResponse;
import com.webservices_with_aws.webservicewithaws.exceptions.UnsupportedMathOperationException;
import com.webservices_with_aws.webservicewithaws.handler.CustomizeResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value="/operations")
public class MathController {

   private static final String message = "Please set a number on request param.";
   @GetMapping(value="/sum/{number1}/{number2}")
   public double sum(@PathVariable(value = "number1") String numberOne,  @PathVariable(value="number2") String numberTwo) throws UnsupportedMathOperationException {
      if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
         // devemos sempre retornar a classe de erro.
         throw  new UnsupportedMathOperationException(message);
      }
      return convertToDouble(numberOne) + convertToDouble(numberTwo);
   }

   @GetMapping(value="/sub/{number1}/{number2}")
   // Vamos receber um parametros de rota são passados como string
   public double sub(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)) {
         throw new UnsupportedMathOperationException(message);
      }
      return convertToDouble(number1) - convertToDouble(number2);
   }


   @GetMapping(value="/multiply/{number1}/{number2}")
   public double multiply(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)){
         throw new UnsupportedMathOperationException(message);
      }
      return convertToDouble(number1) * convertToDouble(number2);
   }

   @GetMapping(value="/division/{number1}/{number2}")
   public double division(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)){
         throw new UnsupportedMathOperationException(message);
      }
      double result = convertToDouble(number1) > convertToDouble(number2) ? convertToDouble(number1) / convertToDouble(number2) : convertToDouble(number2) / convertToDouble(number1);
      return result;
   }

   @GetMapping(value="/average/{number1}/{number2}")
   public double average(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)){
         throw new UnsupportedMathOperationException(message);
      }
      return (convertToDouble(number1) + convertToDouble(number2)) /2;
   }

   @GetMapping(value="/sqrt/{number1}")
   public double sqrt(@PathVariable(value="number1") String number1) throws UnsupportedMathOperationException{
      if(!isNumeric(number1)){
         throw new UnsupportedMathOperationException(message);
      }
      return Math.sqrt(convertToDouble(number1));
   }
   private boolean isNumeric(String stringNumber){
      // verifca se o número é positivo ou negaitvo de 1 a 9 e possui casas decimais
      return stringNumber != null ?  stringNumber.matches("[-+]?[0-9]*\\.?[0-9]+"): false;
   }

   private double convertToDouble(String stringNumber){
      return stringNumber == null ? 0D : Double.parseDouble(stringNumber.replace(',', '.'));
   }




}
