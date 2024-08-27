package com.kanishk.demo.service.employee;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> fetchEmployees();
}
