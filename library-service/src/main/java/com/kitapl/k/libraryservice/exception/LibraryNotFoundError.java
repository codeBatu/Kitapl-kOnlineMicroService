package com.kitapl.k.libraryservice.exception;

public class LibraryNotFoundError extends RuntimeException{

    public  LibraryNotFoundError(String s){
        super(s);
    }
}
