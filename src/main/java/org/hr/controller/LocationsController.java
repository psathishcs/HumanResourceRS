package org.hr.controller;

import java.util.List;
import org.hr.entity.Locations;
import org.hr.repository.LocationsRepository;
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
public class LocationsController {
	@Autowired
	private LocationsRepository repository;
	
	@RequestMapping(value="/locations", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllLocations", nickname="getAllLocations")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Locations.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Locations> getAllLocations(){
		return repository.getAllLocations();
	}
	
	@RequestMapping(value="/locations/{locationID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="locationID", value="location ID", required=true, dataType="Integer", 
		paramType="path")})
	@ApiOperation(value="getLocationsByID", nickname="getLocationsByID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Locations.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Locations getLocationsByID(@PathVariable(value="locationID")Integer locationID){
		return repository.getLocationsByID(locationID);
	}
	
	@RequestMapping(value="/locations/country/{countryID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="countryID", value="country ID", required=true, dataType="String", 
		paramType="path")})
	@ApiOperation(value="getLocationsByCountryID", nickname="getLocationsByCountryID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Locations.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Locations> getLocationsByCountryID(@PathVariable(value="countryID")String countryID){
		return repository.getLocationsByCountryID(countryID);
	}

}
