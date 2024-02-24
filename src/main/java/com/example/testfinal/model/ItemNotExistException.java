package com.example.testfinal.model;

public class ItemNotExistException extends RuntimeException{
    public ItemNotExistException(final String msg) {
        super(msg);
    }
}
