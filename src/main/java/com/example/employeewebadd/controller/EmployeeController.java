package com.example.employeewebadd.controller;


import com.example.employeewebadd.model.Employee;
import com.example.employeewebadd.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.add(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/add-full")
    public ResponseEntity<Employee> add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        Employee employee = employeeService.add(firstName, lastName, salary, departmentId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/remove")
    public ResponseEntity<Employee> remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.remove(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> find(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.find(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<Collection<Employee>> findAll() {
        Collection<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }
}