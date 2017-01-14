package org.hr.controller;

import java.util.List;


import org.hr.entity.Departments;
import org.hr.entity.Employees;
import org.hr.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DepartmentsController {
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@RequestMapping(value="/departments", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllDepartments", nickname="getAllDepartments")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Departments.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Departments> getAllDepartments(){
		return departmentsRepository.getAll();
	}
	
	@RequestMapping(value="/departments/{departmentID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getDepartmentsByID", nickname="getDepartmentsByID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Departments.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Departments getDepartmentsByID(@PathVariable Integer departmentID){
		return departmentsRepository.getByID(departmentID);
	}
	
	@RequestMapping(value="/departments/location/{locationID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getDepartmentsByLocationID", nickname="getDepartmentsByLocationID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Departments.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Departments> getDepartmentsByLocationID(@PathVariable Integer locationID){
		return departmentsRepository.getByLocationID(locationID);
	}


}
