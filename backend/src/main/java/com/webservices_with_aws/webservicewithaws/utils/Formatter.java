package com.webservices_with_aws.webservicewithaws.utils;

public class Formatter {
    public static Double convertToDouble(String stringNumber){
        return stringNumber == null ? 0D : Double.parseDouble(stringNumber.replace(',', '.'));
    }
}

