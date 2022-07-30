package com.employee.employee.service;

import com.employee.employee.controller.EmployeeController;
import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeServiceTest {


    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;


//    private EmployeeController employeeController;

//    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
//      MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void getEmployees() {
        employeeService.getEmployees();
    }

    @Test
    void addEmployee() {
        Employee employee = Employee.builder()
                .speciality("IT")
                .dateOfBirth("12.03.1990")
                .salary(1000)
                .name("test")
                .build();
        employeeService.addEmployee(employee);
        verify(employeeRepository,times(1)).save(employee);
    }

    @Test
    void getEmployeeByName() {
    }

    @Test
    void updateEmployee() throws Exception {
        Employee employee = Employee.builder()
                .speciality("IT")
                .dateOfBirth("12.03.1990")
                .salary(1000)
                .name("test")
                .build();
        Long id = 1L;
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//        Mockito.when( employeeService.getEmployeeById(id)).thenReturn(employee);
        employeeService.updateEmployee(id, employee);
    }

    @Test
    void deleteEmployeeById() {

    }

    @Test
    void getEmployeeById() {
        Employee employee = Employee.builder()
                .speciality("IT")
                .dateOfBirth("12.03.1990")
                .salary(1000)
                .name("test")
                .build();
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        employeeService.getEmployeeById(1L);
    }
}