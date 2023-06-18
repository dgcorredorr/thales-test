package com.thales.test.infrastructure.adapter;

import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.domain.port.spi.EmployeePersistencePort;
import com.thales.test.infrastructure.entity.Employee;
import com.thales.test.infrastructure.mapper.EmployeeMapper;
import com.thales.test.infrastructure.repository.EmployeeJpaRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeePersistenceAdapter implements EmployeePersistencePort {
    private final EmployeeJpaRepository employeeJpaRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeePersistenceAdapter(EmployeeJpaRepository employeeJpaRepository, EmployeeMapper employeeMapper) {
        this.employeeJpaRepository = employeeJpaRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return employeeMapper.toDomain(employeeJpaRepository.save(employeeMapper.toEntity(employeeDto)));
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getId() == null) {
            throw new DataIntegrityViolationException("Employee id not provided");
        } else if (!employeeJpaRepository.existsById(employeeDto.getId())) {
            throw new EntityNotFoundException("Employee not found with id: " + employeeDto.getId());
        } else {
            return employeeMapper.toDomain(employeeJpaRepository.save(employeeMapper.toEntity(employeeDto)));
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeJpaRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeJpaRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        return employeeMapper.toDomain(employee);
    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeJpaRepository.findAll(pageable);
        return employeeMapper.toDomainPage(employeePage);
    }
}
