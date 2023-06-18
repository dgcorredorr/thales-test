import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Employee } from 'src/model/Employee';

@Component({
  selector: 'app-employee-modal',
  templateUrl: './employee-modal.component.html',
  styleUrls: ['./employee-modal.component.css']
})
export class EmployeeModalComponent {
  employee: Employee;
  errorMessage?: string;

  constructor(
    public dialogRef: MatDialogRef<EmployeeModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Employee
  ) {
    this.employee = { ...data };
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }

  onSaveClick(): void {
    if (this.validateForm()) {
      this.dialogRef.close(this.employee);
    }
  }

  validateForm(): boolean {
    this.errorMessage = '';

    if (!this.employee.firstName || !this.employee.lastName || !this.employee.position) {
      this.errorMessage = 'First Name, Last Name, and Position are required fields.';
      return false;
    }

    if (isNaN(this.employee.salary) || Number(this.employee.salary) <= 0) {
      this.errorMessage = 'Salary must be a numeric value greater than zero.';
      return false;
    }

    return true;
  }
}
