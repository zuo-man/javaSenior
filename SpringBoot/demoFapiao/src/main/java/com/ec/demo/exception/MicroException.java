package com.ec.demo.exception;

public class MicroException extends Exception{
    public MicroException(String errCode){
        super(errCode);
    }
}
