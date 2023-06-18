package com.thales.test.infrastructure.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotNull
    @Column(name = "position", nullable = false)
    private String position;
    @NotNull
    @Column(name = "salary", nullable = false)
    private Double salary;
    @Column(name = "annual_salary")
    private Double annualSalary;
}
