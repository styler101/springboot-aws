package com.webservices_with_aws.webservicewithaws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 1L;

    public RessourceNotFoundException(String messsage){
        super(messsage);
    }
}
