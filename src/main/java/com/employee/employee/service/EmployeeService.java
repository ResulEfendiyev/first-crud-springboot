package com.employee.employee.service;

import com.employee.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee addEmployee(Employee employee);
    Employee getEmployeeByName(String name);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployeeById(Long id);

    Employee getEmployeeById(Long id) ;
}
