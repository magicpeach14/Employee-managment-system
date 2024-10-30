package com.srk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srk.entity.Employee;
import com.srk.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmp")
	public String addEmployee(@RequestBody Employee emp) {
		
		String str=employeeService.addEmployee(emp);
		return str;
	}
	
	@DeleteMapping("/deleteEmp")
    public String deleteEmployee(@RequestBody Employee emp) {
		
		String str=employeeService.deleteEmpByID(emp.getEmpId());
		
		return str;
	}
	@PutMapping("/updateEmp")
    public String updateEmployee(@RequestBody Employee emp) {
		
    	String str=employeeService.updateEmployeeDetails(emp);
		return str;
	}
	@GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
		
		List<Employee> emps=employeeService.getAllEmployees();
		return emps;
	}
	@GetMapping("/getEmployeeById")
    public Employee getEmployeeByID(@RequestBody Employee emp) {
		
    	Employee emp1=employeeService.getEmployeeById(emp.getEmpId());
    	return emp1;
	}
	
	
	@GetMapping("/getEmployeesBySalary")
	public List<Employee> getEmployeesBySalary(){
		
		List<Employee> emps=employeeService.getEmployeesBySalary();
		return emps;
	}
	
	@PostMapping("/emplogin")
	public String empLogin(@RequestBody Employee emp) {
		
		String str= employeeService.empLogin(emp);
				return str;
	}
	
}
