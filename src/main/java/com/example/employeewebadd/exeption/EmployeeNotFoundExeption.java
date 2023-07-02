package com.example.employeewebadd.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)

public class EmployeeNotFoundExeption extends RuntimeException{
    public EmployeeNotFoundExeption() {
        super("Employee not found");
    }
}