package com.srk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.srk.entity.Employee;
import com.srk.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	public String addEmployee(Employee emp) {
		
		employeeRepo.save(emp);
		
		return "Employee details added successfully";
	}

	public String deleteEmpByID(Long empId) {
		
		employeeRepo.deleteById(empId);
		return "Employee deleted successfully";
	}

	public String updateEmployeeDetails(Employee emp) {
		
		Employee emp1=employeeRepo.getById(emp.getEmpId());
		
		emp1.setDesignation(emp.getDesignation());
		emp1.setEmail(emp.getEmail());
		emp1.setEmpName(emp.getEmpName());
		emp1.setSalary(emp.getSalary());
		
		employeeRepo.save(emp1);
		return "Employee details added successfully";
	}


	public List<Employee> getAllEmployees() {
		List<Employee> emps=employeeRepo.findAll();
		
		return emps;
	}

	public Employee getEmployeeById(Long empId) {
		
		Employee emp=employeeRepo.findById(empId).get();
		
		return emp;
	}

	public List<Employee> getEmployeesBySalary() {
		
		List<Employee> emps=employeeRepo.getEmployeeBySalary();
		
		return emps;
	}

	public String empLogin(Employee emp) {
		
		Employee emp1=employeeRepo.getById(emp.getEmpId());
		String str="Invalid User";
		if(emp1.getEmail().equals(emp.getEmail())){
		   str="Valid User";
		}
		return str;
	}

	
}
