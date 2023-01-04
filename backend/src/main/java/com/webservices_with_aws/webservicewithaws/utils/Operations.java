package com.webservices_with_aws.webservicewithaws.utils;

public class Operations {
    public static double sum(double number1 , double number2){
        return number1 + number2;
    }

    public static double sub(double number1, double number2){
        return number1 - number2;
    }

    public static double multiply(double number1, double number2){
        return number1 * number2;
    }

    public static double div(double number1, double number2){
        return number1 > number2 ? number1 / number2
                : number1 == number2
                ?  number1 / number2
                : number2/number1;
    }

    public static double average(double number1, double number2){
        return (number1 + number2) /2;
    }

    public static double sqrt(double number){
        return Math.sqrt(number);
    }

}
