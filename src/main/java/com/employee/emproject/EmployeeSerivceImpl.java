package com.employee.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeSerivceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    

    @Override
    public String createEmloyee(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeRepository.save(entity);
        return "Saved employee Successfully";
    }

    @Override
    public List<Employee> readEmloyees() {
        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<Employee>();
        for (EmployeeEntity entity : entities) {
            Employee emp = new Employee();
            emp.setId(entity.getId());
            emp.setName(entity.getName());
            emp.setEmail(entity.getEmail());
            emp.setPhone(entity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmloyees(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id).get();
        employeeRepository.delete(entity);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
       EmployeeEntity entity = employeeRepository.findById(id).get();
       entity.setEmail(employee.getEmail());
       entity.setName(employee.getName());
       entity.setPhone(employee.getPhone());
       employeeRepository.save(entity);
       return "Updated employee Successfully";
    }

    @Override
    public Employee readEmloyee(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id).get();
        Employee emp = new Employee();
        emp.setId(entity.getId());
        emp.setName(entity.getName());
        emp.setEmail(entity.getEmail());
        emp.setPhone(entity.getPhone());
        return emp;
    }

   

}
