package com.kanishk.demo.service.department;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.exception.DepartmentNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

public interface DepartmentService {
    List<Department> saveDepartments(List<Department> department);

    List<Department> fetchDepartments();

    Department fetchDepartment(Long id) throws DepartmentNotFoundException;

    void deleteById(Long id);

    Department updateById(Long id, Department department);

    List<Department> getDepartmentByName(String name);

    Department saveDepartment(@Valid Department department);
}
