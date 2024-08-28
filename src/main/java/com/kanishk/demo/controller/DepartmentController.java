package com.kanishk.demo.controller;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.exception.DepartmentNotFoundException;
import com.kanishk.demo.service.department.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public List<Department> saveDepartments(@Valid @RequestBody List<Department> departments) {
        logger.info("Saving {} departments", departments.size());
        return service.saveDepartments(departments);
    }

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Saving department : {}", department);
        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        logger.info("Fetching department details.");
        return service.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        return service.fetchDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        logger.info("Department with ID {} deleted.", id);
        return "Deletion of data with ID : " + id + " is successful.";
    }

    @PutMapping("/departments/{id}")
    public Department updateById(@PathVariable Long id, @RequestBody Department department) {
        logger.info("Department with ID {} updated.", id);
        return service.updateById(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable String name) {
        return service.getDepartmentByName(name);
    }
}
