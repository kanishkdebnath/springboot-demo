package com.kanishk.demo.controller;

import com.kanishk.demo.entity.Department;
import com.kanishk.demo.exception.DepartmentNotFoundException;
import com.kanishk.demo.service.department.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService service;

    private Department department;

    @BeforeEach
    void setUp() throws DepartmentNotFoundException {
        department = Department.builder()
                .name("IT")
                .address("Delhi")
                .code("IT-1")
                .Id(1L)
                .build();
    }

    @Test
    @DisplayName("Save Department when Valid Data")
    public void saveDepartment() throws Exception {
        Department input = Department.builder()
                .name("IT")
                .address("Delhi")
                .code("IT-1")
                .build();

        Mockito.when(service.saveDepartment(input))
                .thenReturn(department);

        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\t\"name\": \"IT\",\n" +
                        "\t\t\"address\": \"Delhi\",\n" +
                        "\t\t\"code\": \"IT-1\",\n" +
                        "\t\t\"id\": 1\n" +
                        "\t}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get Department for Valid ID")
    void fetchDepartment() throws Exception {
        Mockito.when(service.fetchDepartment(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}