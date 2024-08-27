package com.kanishk.demo.service.department;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.exception.DepartmentNotFoundException;
import com.kanishk.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> saveDepartment(List<Department> departments) {
       return repository.saveAll(departments);
    }

    @Override
    public List<Department> fetchDepartments() {
        return repository.findAll();
    }

    @Override
    public Department fetchDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = repository.findById(id);

        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department with ID : " + id + " is not available.");
        }

        return department.get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateById(Long id, Department department) {
        Department departmentFromDB = repository.findById(id).get();

        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            departmentFromDB.setName(department.getName());
        }
        if (Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            departmentFromDB.setAddress(department.getAddress());
        }
        if (Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())) {
            departmentFromDB.setCode(department.getCode());
        }

        return repository.save(departmentFromDB);
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return repository.findAllByNameIgnoreCase(name);
    }
}
