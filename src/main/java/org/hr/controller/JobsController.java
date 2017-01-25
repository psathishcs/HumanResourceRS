package org.hr.controller;

import java.util.List;

import org.hr.entity.Employees;
import org.hr.entity.Jobs;
import org.hr.repository.JobsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class JobsController {
	private static Logger log = LoggerFactory.getLogger(JobsController.class);
	@Autowired
	private JobsRepository repository;
	
	@RequestMapping(value="/jobs", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllJobs", nickname="getAllJobs")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Jobs.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Jobs> getAllJobs(){
		log.info("getAllJobs");
		return repository.getAll();
	}
	
	@RequestMapping(value="/jobs/{jobID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="jobID", value="Job ID", required=true, dataType="String", 
		paramType="path")})
	@ApiOperation(value="getAllJobs", nickname="getAllJobs")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Jobs.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Jobs getJobsByID(@PathVariable(value="jobID")String jobID){
		log.info("getJobsByID");
		return repository.getJobsByID(jobID);
	}
	
	@RequestMapping(value="/jobs/max/{minSalary}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="minSalary", value="minSalary", required=true, dataType="Double", 
		paramType="path")})
	@ApiOperation(value="getJobsWithSalaryGreaterThan", nickname="getJobsWithSalaryGreaterThan")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Jobs.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Jobs> getJobsWithSalaryGreaterThan(@PathVariable(value="minSalary")Double minSalary){
		log.info("getJobsWithSalaryGreaterThan");
		return repository.getJobsWithSalaryGreaterThan(minSalary);
	}
	
	@RequestMapping(value="/jobs/min/{maxSalary}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="maxSalary", value="maxSalary", required=true, dataType="Double", 
		paramType="path")})
	@ApiOperation(value="getJobsWithSalaryLessThan", nickname="getJobsWithSalaryLessThan")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Jobs.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Jobs> getJobsWithSalaryLessThan(@PathVariable(value="maxSalary")Double maxSalary){
		log.info("getJobsWithSalaryLessThan");
		return repository.getJobsWithSalaryLessThan(maxSalary);
	}

	
	
	
}
