package com.thales.test.domain.service;

import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.domain.port.api.EmployeeServicePort;
import com.thales.test.domain.port.spi.EmployeePersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeServicePort {
    private final EmployeePersistencePort employeePersistencePort;

    public EmployeeServiceImpl(EmployeePersistencePort employeePersistencePort) {
        this.employeePersistencePort = employeePersistencePort;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        employeeDto.setAnnualSalary(calculateAnnualSalary(employeeDto.getSalary()));
        return employeePersistencePort.createEmployee(employeeDto);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        employeeDto.setAnnualSalary(calculateAnnualSalary(employeeDto.getSalary()));
        return employeePersistencePort.updateEmployee(employeeDto);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeePersistencePort.deleteEmployee(employeeId);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return employeePersistencePort.getEmployeeById(employeeId);
    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
        return employeePersistencePort.getAllEmployees(pageable);
    }

    public Double calculateAnnualSalary(Double salary) {
        return salary * 12;
    }
}
