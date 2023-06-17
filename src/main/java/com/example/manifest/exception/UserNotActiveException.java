package com.example.manifest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotActiveException extends RuntimeException{
    public  UserNotActiveException(String message){
        super(message);

    }

}
