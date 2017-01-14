package org.hr.controller;

import java.util.List;

import org.hr.entity.Employees;
import org.hr.entity.JobHistory;
import org.hr.repository.JobHistoryRepository;
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
public class JobHistoryController {
	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	
	@RequestMapping(value="/employees/history", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllJobHistory", nickname="getAllJobHistory")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = JobHistory.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<JobHistory> getAllJobHistory(){
		return jobHistoryRepository.getAll();
	}
	
	@RequestMapping(value="/employees/{employeeID}/history", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getJobHistoryByEmployeeID", nickname="getJobHistoryByEmployeeID")
	@ApiImplicitParams({@ApiImplicitParam(name="employeeID", value="Employee ID", required=true, 
		dataType="Long", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = JobHistory.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<JobHistory> getJobHistoryByEmployeeID(@PathVariable Long employeeID){
		return jobHistoryRepository.getJobHistoryByEmployeeID(employeeID);
	}
	
	@RequestMapping(value="/employees/history/department/{departmentID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getJobHistoryByDepartmentID", nickname="getJobHistoryByDepartmentID")
	@ApiImplicitParams({@ApiImplicitParam(name="departmentID", value="Department ID", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = JobHistory.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<JobHistory> getJobHistoryByDepartmentID(@PathVariable Integer departmentID){
		return jobHistoryRepository.getJobHistoryByDepartmentID(departmentID);
	}
	
	@RequestMapping(value="/employees/history/job/{jobID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getJobHistoryByJobID", nickname="getJobHistoryByJobID")
	@ApiImplicitParams({@ApiImplicitParam(name="jobID", value="Job ID", required=true, 
		dataType="String", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = JobHistory.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<JobHistory> getJobHistoryByJobID(@PathVariable String jobID){
		return jobHistoryRepository.getJobHistoryByJobID(jobID);
	}


	
	
}
