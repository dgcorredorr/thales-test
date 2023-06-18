package com.thales.test.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculateAnnualSalary_ReturnsCorrectAnnualSalary() {
        // Arrange
        double salary = 5000.0;
        Double expectedAnnualSalary = salary * 12;

        // Act
        Double annualSalary = employeeService.calculateAnnualSalary(salary);

        // Assert
        assertEquals(expectedAnnualSalary, annualSalary);
    }
}