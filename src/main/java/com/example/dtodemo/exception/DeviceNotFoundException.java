package com.example.dtodemo.exception;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(String s) {
        super(s);
    }
}
