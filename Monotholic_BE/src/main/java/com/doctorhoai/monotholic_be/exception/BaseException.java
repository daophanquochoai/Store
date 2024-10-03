package com.doctorhoai.monotholic_be.exception;

public class BaseException extends Exception {
    public BaseException(String number, Object p1) {
        super(p1.toString());
    }
}
