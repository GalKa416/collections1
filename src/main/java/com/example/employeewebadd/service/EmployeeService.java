package com.example.employeewebadd.service;

import com.example.employeewebadd.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add (String firstName, String lastName);
    Employee add (String firstName, String lastName, int salary, int departmentId);
    Employee remove (String firstName, String lastName);
    Employee find  (String firstName, String lastName);
    Collection<Employee> findAll();

}
