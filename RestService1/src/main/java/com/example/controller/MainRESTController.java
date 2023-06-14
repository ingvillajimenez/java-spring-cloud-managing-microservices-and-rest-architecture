package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Employee;
import com.example.dao.EmployeeDao;

@RestController
@RequestMapping("/api")
public class MainRESTController {
	
	@Autowired
	private EmployeeDao employeeDAO;
	
	@RequestMapping(
			value = "/employee", 
			method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println("(Service side) Creating employee: " + emp.getEmpNo());
		
		return employeeDAO.addEmployee(emp);
	}
	
	@RequestMapping(
			value = "/employee/{empNo}", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	//http://url:port/context/employee/empno
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") String empNo){
		return employeeDAO.getEmployee(empNo);
	}
	
	@RequestMapping(
			value = "/employees",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)	
	@ResponseBody
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}
	
}
