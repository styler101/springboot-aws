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

   @GetMapping(value="/sum/{number1}/{number2}")
   public double sum(@PathVariable(value = "number1") String numberOne,  @PathVariable(value="number2") String numberTwo) throws UnsupportedMathOperationException {
      if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
         // devemos sempre retornar a classe de erro.
         throw  new UnsupportedMathOperationException("Please set a number on request param.");
      }
      return convertToDouble(numberOne) + convertToDouble(numberTwo);
   }

   @GetMapping(value="/sub/{number1}/{number2}")
   // Vamos receber um parametros de rota são passados como string
   public double sub(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)) {
         throw new UnsupportedMathOperationException("Please set a number on request params");
      }
      return convertToDouble(number1) - convertToDouble(number2);
   }


   @GetMapping(value="/multiply/{number1}/{number2}")
   public double multiply(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      if(!isNumeric(number1) || !isNumeric(number2)){
         throw new UnsupportedMathOperationException("Please set a number on request param.");
      }
      return convertToDouble(number1) * convertToDouble(number2);
   }

   private boolean isNumeric(String stringNumber){
      // verifca se o número é positivo ou negaitvo de 1 a 9 e possui casas decimais
      return stringNumber != null ?  stringNumber.matches("[-+]?[0-9]*\\.?[0-9]+"): false;
   }

   private double convertToDouble(String stringNumber){
      return stringNumber == null ? 0D : Double.parseDouble(stringNumber.replace(',', '.'));
   }




}
