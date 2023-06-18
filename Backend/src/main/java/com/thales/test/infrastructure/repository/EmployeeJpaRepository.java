package com.thales.test.infrastructure.repository;

import com.thales.test.infrastructure.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
