package com.kanishk.demo.service.department;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.exception.DepartmentNotFoundException;
import com.kanishk.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService service;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {
        Department department = new Department(1L, "IT", "Delhi", "IT-01");

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(department));
    }

    @Test
    @DisplayName("Get data based on valid ID")
    public void whenValidDepartmentId_thenDepartmentFound() throws DepartmentNotFoundException {
        Long id = 1L;
        Department found = service.fetchDepartment(id);

        assertEquals(id, found.getId());
    }
}