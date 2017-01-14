package org.hr.controller;

import java.util.List;
import org.hr.entity.Employees;
import org.hr.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeesController {
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllEmployees", nickname="getAllEmployees")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Employees> getAllEmployees(){
		return employeesRepository.getAll();
	}
	
	@RequestMapping(value="/employees/{employeesID}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeesByID", nickname="getEmployeesByID")
	@ApiImplicitParams({@ApiImplicitParam(name="employeesID", value="Employees ID", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Employees getEmployeesByID(@PathVariable Long employeesID){
		System.out.println("inside the controller");
		return employeesRepository.getByID(employeesID);
	}
	
	@RequestMapping(value="/employees/email/{email}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeesByEmail", nickname="getEmployeesByEmail")
	@ApiImplicitParams({@ApiImplicitParam(name="email", value="email", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Employees getEmployeesByEmail(@PathVariable String email){
		System.out.println("inside the controller");
		return employeesRepository.getByEmail(email);
	}
	
	@RequestMapping(value="/employees/department/{departmentID}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeesByDepartmentID", nickname="getEmployeesByDepartmentID")
	@ApiImplicitParams({@ApiImplicitParam(name="departmentID", value="departmentID", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Employees> getEmployeesByDepartmentID(@PathVariable Long departmentID){
		System.out.println("inside the controller");
		return employeesRepository.getByDepartmentID(departmentID);
	}
	
	@RequestMapping(value="/employees/manager/{managerID}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeesByManagerID", nickname="getEmployeesByManagerID")
	@ApiImplicitParams({@ApiImplicitParam(name="managerID", value="managerID", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Employees> getEmployeesByManagerID(@PathVariable Long managerID){
		System.out.println("inside the controller");
		return employeesRepository.getByManagerID(managerID);
	}
	
	@RequestMapping(value="/employees/firstname/{firstName}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeesByFirstName", nickname="getEmployeesByFirstName")
	@ApiImplicitParams({@ApiImplicitParam(name="firstName", value="firstName", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employees.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Employees> getEmployeesByFirstName(@PathVariable String firstName){
		return employeesRepository.getByFirstName(firstName);
	}



}
