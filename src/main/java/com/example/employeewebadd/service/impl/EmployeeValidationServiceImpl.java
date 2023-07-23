package com.example.employeewebadd.service.impl;

import com.example.employeewebadd.exeption.InvalidEmployeeDataExeption;
import com.example.employeewebadd.service.EmployeeValidationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);

    }

    private void validateName(String name) {
        if (!isAlpha(name))
            throw new InvalidEmployeeDataExeption("Некорректное значение имени: " + name);

    }

}
