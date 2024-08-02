package org.springboot.hibernate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springboot.hibernate.exception.ResourceNotFound;
import org.springboot.hibernate.modelentity.Employee;
import org.springboot.hibernate.repository.EmployeeRepository;
import org.springboot.hibernate.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	public EmployeeServiceImpl(EmployeeRepository employeeRepositpory) {
		super();
		this.employeeRepositpory = employeeRepositpory;
	}

	private EmployeeRepository employeeRepositpory;

	@Override
	
	public Employee saveEmployee(Employee employee) {
		
	    System.out.println("First name: " + employee.getFirstName());
	    System.out.println("Last name: " + employee.getLastName());
	    System.out.println("Email: " + employee.getEmail());

	    Employee savedEmployee = employeeRepositpory.save(employee);
	    return savedEmployee;
	}
	public List<Employee>getAllEmployees(){
		return employeeRepositpory.findAll();
		
	}
	 public Employee getEmployeeById(long id) {
		 Optional<Employee> employee = employeeRepositpory.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }else {
			 throw new ResourceNotFound("Employee","Id",id);
		 }
	 }
	 public  Employee updateEmployee(Employee employee,long id) {
		 Employee exisitingEmployee = employeeRepositpory.findById(id).orElseThrow(() -> new ResourceNotFound("Employee","Id",id));
		 ((Employee) exisitingEmployee).setFirstName(employee.getFirstName());
		    ((Employee) exisitingEmployee).setLastName(employee.getLastName());
		    ((Employee) exisitingEmployee).setEmail(employee.getEmail());
		 employeeRepositpory.save(exisitingEmployee);
		 return exisitingEmployee;
		 
	 }
	public void deleteEmployee(long id) {
		employeeRepositpory.findById(id).orElseThrow(() -> new ResourceNotFound("Employee","Id",id));
		employeeRepositpory.deleteById(id);
	}
	}


