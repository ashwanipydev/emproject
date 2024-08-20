package com.employee.emproject;

import java.util.List;

public interface EmployeeService {
    String createEmloyee(Employee employee);

    List<Employee> readEmloyees();

    boolean deleteEmloyees(Long id);

    String updateEmployee(Long id, Employee employee);

    Employee readEmloyee(Long id);

}
