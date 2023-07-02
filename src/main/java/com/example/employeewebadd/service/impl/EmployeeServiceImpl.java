package com.example.employeewebadd.service.impl;

import com.example.employeewebadd.exeption.EmployeeAlreadyAddedException;
import com.example.employeewebadd.exeption.EmployeeNotFoundExeption;
import com.example.employeewebadd.model.Employee;
import com.example.employeewebadd.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service

public class EmployeeServiceImpl implements EmployeeService {
    private  final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee);
        return employee;

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundExeption();
        }

        return employee;
    }
    @Override
    public Collection <Employee> findAll(){
        return employees;
    }
}
