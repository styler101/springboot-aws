package com.webservices_with_aws.webservicewithaws;

import com.webservices_with_aws.webservicewithaws.exceptions.UnsupportedMathOperationException;

import com.webservices_with_aws.webservicewithaws.utils.Formatter;
import com.webservices_with_aws.webservicewithaws.utils.Operations;
import com.webservices_with_aws.webservicewithaws.utils.Validator;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/operations")
public class MathController {

   private static final String message = "Please set a number on request param.";
   @GetMapping(value="/sum/{number1}/{number2}")
   public double sum(@PathVariable(value = "number1") String numberOne,  @PathVariable(value="number2") String numberTwo) throws UnsupportedMathOperationException {
      boolean result  = Validator.validateFields(numberOne, numberTwo);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.sum(Formatter.convertToDouble(numberOne), Formatter.convertToDouble(numberTwo));
   }

   @GetMapping(value="/sub/{number1}/{number2}")
   // Vamos receber um parametros de rota são passados como string
   public double sub(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2) throws UnsupportedMathOperationException{
      boolean result  = Validator.validateFields(number1, number2);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.sub(Formatter.convertToDouble(number1), Formatter.convertToDouble(number2));
   }


   @GetMapping(value="/multiply/{number1}/{number2}")
   public double multiply(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      boolean result  = Validator.validateFields(number1, number2);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.multiply(Formatter.convertToDouble(number1), Formatter.convertToDouble(number2));
   }

   @GetMapping(value="/division/{number1}/{number2}")
   public double division(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      boolean result  = Validator.validateFields(number1, number2);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.div(Formatter.convertToDouble(number1), Formatter.convertToDouble(number2));
   }

   @GetMapping(value="/average/{number1}/{number2}")
   public double average(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws UnsupportedMathOperationException{
      boolean result  = Validator.validateFields(number1, number2);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.average(Formatter.convertToDouble(number1), Formatter.convertToDouble(number2));
   }

   @GetMapping(value="/sqrt/{number1}")
   public double sqrt(@PathVariable(value="number1") String number1) throws UnsupportedMathOperationException{
      boolean result  = Validator.validateField(number1);
      if(!result) throw new UnsupportedMathOperationException(message);
      return Operations.sqrt(Formatter.convertToDouble(number1));
   }





}
