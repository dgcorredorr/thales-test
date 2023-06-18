package com.thales.test.application.controller;

import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.domain.port.api.EmployeeServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @Mock
    private EmployeeServicePort employeeServicePort;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmployee_ValidEmployee_ReturnsCreatedResponse() {
        // Arrange
        EmployeeDto employeeDto = new EmployeeDto();
        // Set up mock behavior
        when(employeeServicePort.createEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.createEmployee(employeeDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void updateEmployee_ValidEmployee_ReturnsOkResponse() {
        // Arrange
        EmployeeDto employeeDto = new EmployeeDto();
        // Set up mock behavior
        when(employeeServicePort.updateEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.updateEmployee(employeeDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void deleteEmployee_ExistingEmployee_ReturnsNoContentResponse() {
        // Arrange
        Long employeeId = 1L;

        // Act
        ResponseEntity<Void> response = employeeController.deleteEmployee(employeeId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void getEmployeeById_ExistingEmployee_ReturnsOkResponse() {
        // Arrange
        Long employeeId = 1L;
        EmployeeDto employeeDto = new EmployeeDto();
        // Set up mock behavior
        when(employeeServicePort.getEmployeeById(anyLong())).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.getEmployeeById(employeeId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void getAllEmployees_ReturnsOkResponseWithEmployeePage() {
        // Arrange
        List<EmployeeDto> employees = new ArrayList<>();
        employees.add(new EmployeeDto());
        employees.add(new EmployeeDto());
        Page<EmployeeDto> employeePage = new PageImpl<>(employees);
        Pageable pageable = Pageable.unpaged();
        // Set up mock behavior
        when(employeeServicePort.getAllEmployees(any(Pageable.class))).thenReturn(employeePage);

        // Act
        ResponseEntity<Page<EmployeeDto>> response = employeeController.getAllEmployees(pageable);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeePage, response.getBody());
    }

    @Test
    void handleEntityNotFoundException_ReturnsNotFoundResponse() {
        // Arrange
        EntityNotFoundException ex = new EntityNotFoundException("Employee not found");

        // Act
        ResponseEntity<String> response = employeeController.handleEntityNotFoundException(ex);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Employee not found", response.getBody());
    }

    @Test
    void handleDataIntegrityViolationException_ReturnsBadRequestResponse() {
        // Arrange
        DataIntegrityViolationException ex = new DataIntegrityViolationException("Data integrity violation");

        // Act
        ResponseEntity<String> response = employeeController.handleDataIntegrityViolationException(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Data integrity violation", response.getBody());
    }

    @Test
    void handleException_ReturnsInternalServerErrorResponse() {
        // Arrange
        Exception ex = new Exception("Internal Server Error");

        // Act
        ResponseEntity<String> response = employeeController.handleException(ex);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
    }
}
