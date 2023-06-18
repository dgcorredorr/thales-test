# Project README

This README provides information about the project, its dependencies, and documentation for the service endpoints.

## Project Overview

The project consists of an Angular frontend application and a Spring Boot backend service. The Angular application is responsible for the user interface, while the Spring Boot service handles the backend logic and data storage.

### Dependencies

#### Angular Frontend Application (package.json)

- @angular/animations: ^15.2.0
- @angular/cdk: ^15.2.9
- @angular/common: ^15.2.0
- @angular/compiler: ^15.2.0
- @angular/core: ^15.2.0
- @angular/forms: ^15.2.0
- @angular/material: ^15.2.9
- @angular/platform-browser: ^15.2.0
- @angular/platform-browser-dynamic: ^15.2.0
- @angular/router: ^15.2.0
- ngx-pagination: ^6.0.3
- rxjs: ~7.8.0
- tslib: ^2.3.0
- zone.js: ~0.12.0

#### Spring Boot Backend Service (pom.xml)

- Spring Boot: 2.7.11
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Undertow (provided scope)
- Spring Boot Starter Validation
- H2 Database (runtime scope)
- Project Lombok
- Spring Boot Starter Test (test scope)
- JBoss XNIO API: 3.8.8.Final

### Prerequisites

To run the project, you need to have the following dependencies installed:

- Node.js
- Angular CLI
- Java 8 or higher
- Maven
- WildFly 24

Make sure to set up a H2 database datasource named `java:/test` in your WildFly server.

## Angular Frontend

The Angular frontend application is responsible for the user interface and interaction with the backend service.

### Installation

1. Clone the project repository.
2. Navigate to the `frontend` directory.
3. Run `npm install` to install the project dependencies.

### Development Server

To start the development server, run `npm start` or `ng serve` from the `frontend` directory. The application will be accessible at `http://localhost:4200`.

### Building the Application

To build the application, run `npm run build` or `ng build`. The build artifacts will be stored in the `frontend/dist` directory.

## Spring Boot Backend Service

The Spring Boot backend service provides the RESTful APIs for managing employees.

### Building the Application

To build the Spring Boot application, run `mvn clean package -Pprod test -Pdev` from the project's `backend` directory. This will create a WAR file in the `target` directory.

### Deploying the Application

Deploy the generated WAR file to your WildFly server. Make sure the server is running and has the H2 datasource configured.

### API Documentation

The backend service exposes the following endpoints:

- **GET /api/v1/employees**: Retrieves a paginated list of all employees. Accepts optional pagination parameters: `page`, `size`, and `sort`.

- **GET /api/v1/employee/{employeeId}**: Retrieves a specific employee by ID.

- **POST /api/v1/employee**: Creates a new employee. Requires a JSON payload with the employee data.

- **PUT /api/v1/employee**: Updates an existing employee. Requires a JSON payload with the updated employee data.

- **DELETE /api/v1/employee/{employeeId}**: Deletes a specific employee by ID.

Make HTTP requests to the respective endpoints to interact with the employee management system.

#### Employee Object Example
```json
{
    "id": 1,
    "firstName": "Michael",
    "lastName": "Scott",
    "position": "Regional Manager",
    "salary": 5000.0,
    "annualSalary": 60000.0
}
```
#### Paginated Employee List
```json
{
    "content": [
        {
            "id": 1,
            "firstName": "Michael",
            "lastName": "Scott",
            "position": "Regional Manager",
            "salary": 5000.0,
            "annualSalary": 60000.0
        },
        {
            "id": 2,
            "firstName": "Jim",
            "lastName": "Halpert",
            "position": "Sales Representative",
            "salary": 4000.0,
            "annualSalary": 48000.0
        },
        {
            "id": 3,
            "firstName": "Dwight",
            "lastName": "Schrute",
            "position": "Assistant to the Regional Manager",
            "salary": 3800.0,
            "annualSalary": 45600.0
        },
        {
            "id": 4,
            "firstName": "Pam",
            "lastName": "Beesly",
            "position": "Receptionist",
            "salary": 3500.0,
            "annualSalary": 42000.0
        },
        {
            "id": 5,
            "firstName": "Angela",
            "lastName": "Martin",
            "position": "Senior Accountant",
            "salary": 4500.0,
            "annualSalary": 54000.0
        },
        {
            "id": 6,
            "firstName": "Ryan",
            "lastName": "Howard",
            "position": "Temp",
            "salary": 3000.0,
            "annualSalary": 36000.0
        },
        {
            "id": 7,
            "firstName": "Oscar",
            "lastName": "Martinez",
            "position": "Accountant",
            "salary": 3900.0,
            "annualSalary": 46800.0
        },
        {
            "id": 8,
            "firstName": "Kelly",
            "lastName": "Kapoor",
            "position": "Customer Service Representative",
            "salary": 3200.0,
            "annualSalary": 38400.0
        },
        {
            "id": 9,
            "firstName": "Kevin",
            "lastName": "Malone",
            "position": "Accountant",
            "salary": 4200.0,
            "annualSalary": 50400.0
        },
        {
            "id": 10,
            "firstName": "Stanley",
            "lastName": "Hudson",
            "position": "Sales Representative",
            "salary": 4100.0,
            "annualSalary": 49200.0
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageSize": 20,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 10,
    "totalPages": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 10,
    "first": true,
    "empty": false
}
```

## Conclusion

This README provides an overview of the project, its dependencies, and instructions for running the frontend and backend components. Refer to the specific sections for detailed information on installation, configuration, building, and running the application.