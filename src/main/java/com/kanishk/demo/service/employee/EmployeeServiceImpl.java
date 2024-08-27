package com.kanishk.demo.service.employee;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.entity.Employee;
import com.kanishk.demo.repository.DepartmentRepository;
import com.kanishk.demo.repository.EmployeeRepository;
import com.kanishk.demo.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployees() {
        return repository.findAll();
    }
}
