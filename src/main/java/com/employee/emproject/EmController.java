package com.employee.emproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://ashwanipydev.github.io")
public class EmController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmloyees();
    }
    
    @GetMapping("/employees/{id}")
    public Employee getEmployeesById(@PathVariable Long id) {
        return employeeService.readEmloyee(id);
    }
    
    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employees) {
        return employeeService.createEmloyee(employees);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmloyees(id)) {
            return "Delete employee successfully";
        }
        return "Not Found";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
