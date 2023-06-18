import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Employee } from 'src/model/Employee';
import { Page } from 'src/model/Page';
import { AppService } from './app.service';
import { DeleteConfirmationComponent } from './delete-confirmation/delete-confirmation.component';
import { EmployeeModalComponent } from './employee-modal/employee-modal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'position', 'salary', 'annualSalary', 'actions'];
  employees: Employee[] = [];
  page?: Page<Employee>;
  pageSize = 10;
  currentPage = 0;
  searchQuery = '';

  pageSizeOptions = [5, 10, 25, 100];

  constructor(
    private appService: AppService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(page: number = this.currentPage): void {
    this.appService.getAllEmployees({ page: page, size: this.pageSize })
      .subscribe({
        next: (response: Page<Employee>) => {
          this.page = response;
          this.employees = response.content;
          this.currentPage = page;
        },
        error: () => {

        }
      });
  }

  onPageChange(event: PageEvent): void {
    this.pageSize = event.pageSize
    this.loadEmployees(event.pageIndex);
  }

  searchEmployees(): void {
    if (!this.searchQuery) {
      this.pageSize = 10;
      this.currentPage = 0;
      this.loadEmployees();
      return;
    }

    const employeeId = Number(this.searchQuery);
    if (!isNaN(employeeId)) {
      this.appService.getEmployeeById(employeeId)
        .subscribe({
          next: (employee: Employee) => {
            if (employee) {
              this.employees = [employee];
              this.page = {
                content: [employee],
                totalElements: 1,
                totalPages: 1
              };
              this.pageSize = 1;
              this.currentPage = 0;
            } else {
              this.snackBar.open('Employee not found', 'Dismiss', { duration: 3000 });
            }
          },
          error: (error: HttpErrorResponse) => {
            console.error(error)
            this.snackBar.open(
              'Employee not found', 'Dismiss', { duration: 3000 });
          }
        });
    } else {
      this.snackBar.open('Invalid employee ID', 'Dismiss', { duration: 3000 });
    }
  }

  openEmployeeModal(employee?: Employee): void {
    const dialogRef = this.dialog.open(EmployeeModalComponent, {
      width: '800px',
      data: employee ? { ...employee } : null
    });

    dialogRef.afterClosed().subscribe((result: Employee) => {
      if (result) {
        if (result?.id) {
          this.appService.updateEmployee(result).subscribe({
            next: (employee: Employee) => {
              this.snackBar.open(`Employee ${employee.firstName} ${employee.lastName} succesfully updated`, 'Dismiss', { duration: 3000 });
            }
          })
        } else {
          this.appService.createEmployee(result).subscribe({
            next: (employee: Employee) => {
              this.snackBar.open(`Employee ${employee.firstName} ${employee.lastName} succesfully created`, 'Dismiss', { duration: 3000 });
            }
          })
        }
        this.pageSize = 10;
        this.currentPage = 0;
        this.loadEmployees();
      }
    });
  }

  openDeleteConfirmation(employee: Employee): void {
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {
      width: '400px',
      data: employee
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.appService.deleteEmployee(employee.id!).subscribe({
          next: () => {
            this.snackBar.open(`Employee ${employee.firstName} ${employee.lastName} succesfully deleted`, 'Dismiss', { duration: 3000 });
            this.pageSize = 10;
            this.currentPage = 0;
            this.loadEmployees();
          }
        })
      }
    });
  }
}
