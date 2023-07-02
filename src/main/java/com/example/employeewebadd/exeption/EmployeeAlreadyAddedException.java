package com.example.employeewebadd.exeption;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Employee already  added");
    }
}
