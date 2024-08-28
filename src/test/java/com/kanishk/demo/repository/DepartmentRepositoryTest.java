package com.kanishk.demo.repository;

import com.kanishk.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = new Department(1L, "IT", "Delhi", "IT-01");

        entityManager.merge(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department found = repository.findById(1L).get();

        assertEquals(found.getId(), 1L);
    }
}