package org.springboot.hibernate.service;

import java.util.List;

import org.springboot.hibernate.modelentity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
    List<Employee>getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
