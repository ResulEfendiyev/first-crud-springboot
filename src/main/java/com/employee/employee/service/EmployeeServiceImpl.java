package com.employee.employee.service;

import com.employee.employee.entity.Employee;
import com.employee.employee.error.EmployeeNotFoundException;
import com.employee.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name).get();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee foundEmployee = employeeRepository.findById(id).get();
        if (foundEmployee != null) {
            if (employee.getName() != null || !employee.getName().equals("")) {
                foundEmployee.setName(employee.getName());
            }
            if (employee.getSalary() != 0) {
                foundEmployee.setSalary(employee.getSalary());
            }
            if (employee.getSpeciality() != null || !employee.getSpeciality().equals("")) {
                foundEmployee.setSpeciality(employee.getSpeciality());
            }
        }
        employeeRepository.save(foundEmployee);
        return foundEmployee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if (!foundEmployee.isPresent()) {
            throw new EmployeeNotFoundException("Employee not available");
        }
        return foundEmployee.get();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
