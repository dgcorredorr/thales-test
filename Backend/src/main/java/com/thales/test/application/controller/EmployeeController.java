package com.thales.test.application.controller;

import com.thales.test.application.data.ResponseMessageDto;
import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.domain.port.api.EmployeeServicePort;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeServicePort employeeServicePort;

    public EmployeeController(EmployeeServicePort employeeServicePort) {
        this.employeeServicePort = employeeServicePort;
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeServicePort.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeServicePort.updateEmployee(employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeServicePort.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employee = employeeServicePort.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<EmployeeDto>> getAllEmployees(
            Pageable pageable) {
        Page<EmployeeDto> employeePage = employeeServicePort.getAllEmployees(pageable);
        return ResponseEntity.ok(employeePage);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseMessageDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseMessageDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseMessageDto> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessageDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build());
    }

}
