package com.zied.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zied.API.model.Employee;
import com.zied.API.service.EmployeeService;

import java.util.Optional;

// @RestController : Comme @Component, elle permet d’indiquer à Spring que cette classe est un bean
// Elle indique à Spring d’insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get all : retourne tous les employés
     * @return : Objets Employee itérables
     */
    @GetMapping("/employees")  // signifie que les requêtes HTTP de type GET à l’URL "/employees" exécuteront le code de cette méthode getEmployees()
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    /**
     * Get one : retourne un seul employé
     * @param id
     * @return : un objet Employee
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    /**
     * Create one - Ajouter un objet Emoloyee
     * @param employee un objet employee
     * @return l'objet Employee sauvegardé
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    /**
     * Update - mettre à jour un objet Employee existant
     * @param id - L'id de l' employee à mettre à jour
     * @param employee
     * @return - l'objet Employee mis à jour
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if(firstName != null) {
                currentEmployee.setFirstName(firstName);
            }
            String lastName = employee.getLastName();
            if(lastName != null) {
                currentEmployee.setLastName(lastName);;
            }
            String mail = employee.getMail();
            if(mail != null) {
                currentEmployee.setMail(mail);
            }
            String password = employee.getPassword();
            if(password != null) {
                currentEmployee.setPassword(password);;
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else {
            return null;
        }
    }


    /**
     * Delete - Supprimer un employé dans la BD
     * @param id - l'objet Employee mis à supprimer
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }

}