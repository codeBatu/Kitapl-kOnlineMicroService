package com.kitapl.k.bookservice.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s){
        super(s);
    }
}
