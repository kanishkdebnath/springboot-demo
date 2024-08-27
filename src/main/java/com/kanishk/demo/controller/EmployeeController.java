package com.kanishk.demo.controller;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.entity.Employee;
import com.kanishk.demo.service.department.DepartmentService;
import com.kanishk.demo.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        logger.info("Saving employee : {}", employee);
        return service.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployees() {
        logger.info("Fetching employee details.");
        return service.fetchEmployees();
    }
}
