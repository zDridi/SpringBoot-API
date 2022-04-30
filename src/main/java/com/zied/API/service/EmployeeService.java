package com.zied.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zied.API.model.Employee;
import com.zied.API.repository.EmployeeRepository;

import lombok.Data;

@Data
@Service                                    // @Service  : c’est une spécialisation de @Component. Son rôle est donc le même, mais son nom a une valeur sémantique
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

}