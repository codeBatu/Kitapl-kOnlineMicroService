package com.kitapl.k.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(LibraryNotFoundError.class)
    public ResponseEntity<?>handle(LibraryNotFoundError exp){
        return  new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?>handle(BookNotFoundException exp){
        return  new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
}
