package com.employee.employee.controller;

import com.employee.employee.entity.Employee;
import com.employee.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;
    @Value("${hello.message}")
    private String helloMessage;

    @GetMapping("/")
    public String helloEmployee() {
        return helloMessage;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employees/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping("/employees/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        log.info("get employee by id " + id);
        return employeeService.getEmployeeById(id);
    }
}
