package com.employee.employee.repository;

import com.employee.employee.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void itShouldCheckIfEmployeeExists() {
        Employee employee = Employee.builder()
                .name("test1")
                .salary(1000)
                .dateOfBirth("12.03.2022")
                .speciality("IT")
                .build();
        repository.save(employee);

        Optional<Employee> test1 = repository.findByName("test1");
        assertThat(test1.isPresent()).isTrue();
    }

    @Test
    void itShouldCheckIfEmployeeDoesNotExists() {


        Optional<Employee> test1 = repository.findByName("test1");
        assertThat(test1.isPresent()).isFalse();
    }
}