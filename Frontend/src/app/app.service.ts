import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from 'src/model/Employee';
import { Page } from 'src/model/Page';
import { Pagination } from 'src/model/Pagination';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  getAllEmployees(pagination?: Pagination): Observable<Page<Employee>> {
    let params;
    if (pagination) {
        params = new HttpParams()
        .set('page', pagination.page ? pagination.page.toString() : '0')
        .set('size', pagination.size ? pagination.size.toString() : '10')
        .set('sort', pagination.sort ? pagination.sort.toString() : 'id,asc');
    }
    return this.http.get<Page<Employee>>(`${this.apiUrl}/employees`, { params });
  }

  getEmployeeById(employeeId: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.apiUrl}/employee/${employeeId}`);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiUrl}/employee`, employee);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiUrl}/employee`, employee);
  }

  deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/employee/${employeeId}`);
  }
}
