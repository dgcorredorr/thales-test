package com.thales.test.infrastructure.mapper;

import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.infrastructure.entity.Employee;
import org.springframework.stereotype.Component;

/**
 * This class extends the Mapper class to provide mapping functionality
 * specific to EmployeeDto and Employee entity objects.
 *
 * @author David Corredor R. - dgcorredorr@gmail.com
 */
@Component
public class EmployeeMapper extends AbstractMapper<EmployeeDto, Employee> {
    @Override
    public EmployeeDto toDomain(Employee entity) {
        return (entity != null) ? EmployeeDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .position(entity.getPosition())
                .salary(entity.getSalary())
                .annualSalary(entity.getAnnualSalary())
                .build() : null;
    }

    @Override
    public Employee toEntity(EmployeeDto dto) {
        return (dto != null) ? Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .position(dto.getPosition())
                .salary(dto.getSalary())
                .annualSalary(dto.getAnnualSalary())
                .build() : null;
    }
}
