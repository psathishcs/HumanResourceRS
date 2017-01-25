package org.hr.controller;

import java.util.List;

import org.hr.entity.Countries;
import org.hr.entity.Departments;
import org.hr.repository.CountriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CountriesController {
	private static Logger log = LoggerFactory.getLogger(CountriesController.class);
	@Autowired
	private CountriesRepository repository;

	@RequestMapping(value="/countries", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllCountries", nickname="getAllCountries")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Countries.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Countries> getAllCountries(){
		log.info("getAllCountries");
		return repository.getAll();
	}
	
	@RequestMapping(value="/countries/{countryID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="countryID", value="countryID", required=true, dataType="String", 
		paramType="path")})
	@ApiOperation(value="getByCountriesByID", nickname="getByCountriesByID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Countries.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Countries getByCountriesByID(@PathVariable String countryID){
		log.info("getByCountriesByID");
		return repository.getByCountriesByID(countryID);
	}
	
	@RequestMapping(value="/countries/region/{regionID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="regionID", value="regionID", required=true, dataType="Integer", 
		paramType="path")})
	@ApiOperation(value="getByCountriesByRegionID", nickname="getByCountriesByRegionID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Countries.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Countries> getByCountriesByRegionID(@PathVariable Integer regionID ){
		log.info("getByCountriesByRegionID");
		return repository.getByCountriesByRegionID(regionID);
	}
	

}
