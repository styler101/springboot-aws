package com.webservices_with_aws.webservicewithaws.utils;

import com.webservices_with_aws.webservicewithaws.exceptions.UnsupportedMathOperationException;

public class Validator {
    public static boolean isNumeric(String stringNumber){
        // verifca se o número é positivo ou negaitvo de 1 a 9 e possui casas decimais
        return stringNumber != null ?  stringNumber.matches("[-+]?[0-9]*\\.?[0-9]+"): false;
    }


    public static boolean validateFields(String number1, String number2)  {
        // devemos sempre retornar a classe de erro.
       return  (!isNumeric(number1) || !isNumeric(number2)) ? false : true;
    }

    public static boolean validateField(String number1){
        return !isNumeric(number1) ? false : true;
    }
}
