package com.example.employeewebadd.service.impl;

import org.springframework.stereotype.Service;
import com.example.employeewebadd.exeption.EmployeeAlreadyAddedException;
import com.example.employeewebadd.exeption.EmployeeNotFoundExeption;
import com.example.employeewebadd.model.Employee;
import com.example.employeewebadd.service.EmployeeService;


import java.util.Collection;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private  final Map<String,Employee> employees;

    public EmployeeServiceImpl() {

        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee.getFullName());
        return employee;

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundExeption();

        }

        return employee;
    }
    @Override
    public Collection <Employee> findAll(){

        return employees.values();
    }
}
