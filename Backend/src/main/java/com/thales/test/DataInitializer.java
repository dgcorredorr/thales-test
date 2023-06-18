package com.thales.test;

import com.thales.test.domain.data.EmployeeDto;
import com.thales.test.domain.port.api.EmployeeServicePort;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private final EmployeeServicePort employeeServicePort;

    public DataInitializer(EmployeeServicePort employeeServicePort) {
        this.employeeServicePort = employeeServicePort;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Employee 1
        EmployeeDto employee1 = EmployeeDto.builder()
                .firstName("Michael")
                .lastName("Scott")
                .position("Regional Manager")
                .salary(5000.0)
                .build();
        employeeServicePort.createEmployee(employee1);

// Employee 2
        EmployeeDto employee2 = EmployeeDto.builder()
                .firstName("Dwight")
                .lastName("Schrute")
                .position("Assistant to the Regional Manager")
                .salary(4000.0)
                .build();
        employeeServicePort.createEmployee(employee2);

// Employee 3
        EmployeeDto employee3 = EmployeeDto.builder()
                .firstName("Jim")
                .lastName("Halpert")
                .position("Sales Representative")
                .salary(3800.0)
                .build();
        employeeServicePort.createEmployee(employee3);

// Employee 4
        EmployeeDto employee4 = EmployeeDto.builder()
                .firstName("Pam")
                .lastName("Beesly")
                .position("Receptionist")
                .salary(3500.0)
                .build();
        employeeServicePort.createEmployee(employee4);

// Employee 5
        EmployeeDto employee5 = EmployeeDto.builder()
                .firstName("Angela")
                .lastName("Martin")
                .position("Senior Accountant")
                .salary(4500.0)
                .build();
        employeeServicePort.createEmployee(employee5);

// Employee 6
        EmployeeDto employee6 = EmployeeDto.builder()
                .firstName("Kevin")
                .lastName("Malone")
                .position("Accountant")
                .salary(4200.0)
                .build();
        employeeServicePort.createEmployee(employee6);

// Employee 7
        EmployeeDto employee7 = EmployeeDto.builder()
                .firstName("Oscar")
                .lastName("Martinez")
                .position("Accountant")
                .salary(3900.0)
                .build();
        employeeServicePort.createEmployee(employee7);

// Employee 8
        EmployeeDto employee8 = EmployeeDto.builder()
                .firstName("Stanley")
                .lastName("Hudson")
                .position("Sales Representative")
                .salary(4100.0)
                .build();
        employeeServicePort.createEmployee(employee8);

// Employee 9
        EmployeeDto employee9 = EmployeeDto.builder()
                .firstName("Meredith")
                .lastName("Palmer")
                .position("Supplier Relations")
                .salary(3200.0)
                .build();
        employeeServicePort.createEmployee(employee9);

// Employee 10
        EmployeeDto employee10 = EmployeeDto.builder()
                .firstName("Creed")
                .lastName("Bratton")
                .position("Quality Assurance")
                .salary(3000.0)
                .build();
        employeeServicePort.createEmployee(employee10);
// Employee 11
        EmployeeDto employee11 = EmployeeDto.builder()
                .firstName("Ryan")
                .lastName("Howard")
                .position("Temp")
                .salary(2800.0)
                .build();
        employeeServicePort.createEmployee(employee11);

// Employee 12
        EmployeeDto employee12 = EmployeeDto.builder()
                .firstName("Toby")
                .lastName("Flenderson")
                .position("Human Resources")
                .salary(3800.0)
                .build();
        employeeServicePort.createEmployee(employee12);

// Employee 13
        EmployeeDto employee13 = EmployeeDto.builder()
                .firstName("Kelly")
                .lastName("Kapoor")
                .position("Customer Service")
                .salary(3200.0)
                .build();
        employeeServicePort.createEmployee(employee13);

// Employee 14
        EmployeeDto employee14 = EmployeeDto.builder()
                .firstName("Phyllis")
                .lastName("Lapin-Vance")
                .position("Sales Representative")
                .salary(3700.0)
                .build();
        employeeServicePort.createEmployee(employee14);

// Employee 15
        EmployeeDto employee15 = EmployeeDto.builder()
                .firstName("Andy")
                .lastName("Bernard")
                .position("Sales Representative")
                .salary(4000.0)
                .build();
        employeeServicePort.createEmployee(employee15);

// Employee 16
        EmployeeDto employee16 = EmployeeDto.builder()
                .firstName("Darryl")
                .lastName("Philbin")
                .position("Warehouse Foreman")
                .salary(3500.0)
                .build();
        employeeServicePort.createEmployee(employee16);

// Employee 17
        EmployeeDto employee17 = EmployeeDto.builder()
                .firstName("Holly")
                .lastName("Flax")
                .position("Human Resources")
                .salary(3900.0)
                .build();
        employeeServicePort.createEmployee(employee17);

// Employee 18
        EmployeeDto employee18 = EmployeeDto.builder()
                .firstName("Karen")
                .lastName("Filippelli")
                .position("Regional Manager")
                .salary(4200.0)
                .build();
        employeeServicePort.createEmployee(employee18);

// Employee 19
        EmployeeDto employee19 = EmployeeDto.builder()
                .firstName("Gabe")
                .lastName("Lewis")
                .position("Coordinador of Sales")
                .salary(3600.0)
                .build();
        employeeServicePort.createEmployee(employee19);

// Employee 20
        EmployeeDto employee20 = EmployeeDto.builder()
                .firstName("Erin")
                .lastName("Hannon")
                .position("Receptionist")
                .salary(3300.0)
                .build();
        employeeServicePort.createEmployee(employee20);
// Employee 21
        EmployeeDto employee21 = EmployeeDto.builder()
                .firstName("Clark")
                .lastName("Green")
                .position("Sales Representative")
                .salary(3800.0)
                .build();
        employeeServicePort.createEmployee(employee21);

// Employee 22
        EmployeeDto employee22 = EmployeeDto.builder()
                .firstName("Nellie")
                .lastName("Bertram")
                .position("Special Projects")
                .salary(3900.0)
                .build();
        employeeServicePort.createEmployee(employee22);

// Employee 23
        EmployeeDto employee23 = EmployeeDto.builder()
                .firstName("Robert")
                .lastName("California")
                .position("CEO")
                .salary(8000.0)
                .build();
        employeeServicePort.createEmployee(employee23);

// Employee 24
        EmployeeDto employee24 = EmployeeDto.builder()
                .firstName("Pete")
                .lastName("Miller")
                .position("Sales Representative")
                .salary(3600.0)
                .build();
        employeeServicePort.createEmployee(employee24);

// Employee 25
        EmployeeDto employee25 = EmployeeDto.builder()
                .firstName("Val")
                .lastName("Johnson")
                .position("Warehouse Worker")
                .salary(3200.0)
                .build();
        employeeServicePort.createEmployee(employee25);

// Employee 26
        EmployeeDto employee26 = EmployeeDto.builder()
                .firstName("Cathy")
                .lastName("Simms")
                .position("Sales Representative")
                .salary(3500.0)
                .build();
        employeeServicePort.createEmployee(employee26);

// Employee 27
        EmployeeDto employee27 = EmployeeDto.builder()
                .firstName("Josh")
                .lastName("Porter")
                .position("Regional Manager")
                .salary(4200.0)
                .build();
        employeeServicePort.createEmployee(employee27);

// Employee 28
        EmployeeDto employee28 = EmployeeDto.builder()
                .firstName("Deangelo")
                .lastName("Vickers")
                .position("Regional Manager")
                .salary(4000.0)
                .build();
        employeeServicePort.createEmployee(employee28);

// Employee 29
        EmployeeDto employee29 = EmployeeDto.builder()
                .firstName("Charles")
                .lastName("Minor")
                .position("Regional Manager")
                .salary(4500.0)
                .build();
        employeeServicePort.createEmployee(employee29);

// Employee 30
        EmployeeDto employee30 = EmployeeDto.builder()
                .firstName("Trevor")
                .lastName("Briggs")
                .position("Sales Representative")
                .salary(3700.0)
                .build();
        employeeServicePort.createEmployee(employee30);

    }
}

