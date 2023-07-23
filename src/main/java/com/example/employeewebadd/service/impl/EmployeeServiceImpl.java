package com.example.employeewebadd.service.impl;

import com.example.employeewebadd.service.EmployeeValidationService;
import org.springframework.stereotype.Service;
import com.example.employeewebadd.exeption.EmployeeAlreadyAddedException;
import com.example.employeewebadd.exeption.EmployeeNotFoundExeption;
import com.example.employeewebadd.model.Employee;
import com.example.employeewebadd.service.EmployeeService;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;


@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;

        this.employees = new HashMap<>();

        add("Ivan", "Ivanov");
        add("Petr", "Petrov");
        add("Stepan", "Stepanov");
        add("Sergey", "Sergeev");
        add("Andrev", "Andreev");
        add("Nikolay", "nikolaev");
    }


    @Override
    public Employee add(String firstName, String lastName) {
        validationService.validate(firstName,lastName);
        Employee employee = new Employee(capitalize (firstName), capitalize(lastName));

        return add(employee);
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        validationService.validate(firstName,lastName);
        Employee employee = new Employee(capitalize (firstName), capitalize(lastName), salary, departmentId);

        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName)  {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee.getFullName());
        return employee;

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundExeption();

        }

        return employee;
    }

    @Override
    public Collection<Employee> findAll() {

        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}

