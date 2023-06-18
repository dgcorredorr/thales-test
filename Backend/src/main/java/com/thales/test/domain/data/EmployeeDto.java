package com.thales.test.domain.data;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Double salary;
    private Double annualSalary;
}
