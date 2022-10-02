package com.kitapl.k.libraryservice.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s){
        super(s);
    }
}
