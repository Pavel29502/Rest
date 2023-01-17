package com.example.demo2.exception;

public class NotFoundException extends Exception {
    // Cоздаю свой эксепшн.
    public NotFoundException(String message) {
        super(message);
    }

}
