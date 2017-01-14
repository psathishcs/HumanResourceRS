package org.hr.controller;

import java.util.List;

import org.hr.entity.Locations;
import org.hr.entity.Regions;
import org.hr.repository.LocationsRepository;
import org.hr.repository.RegionRepository;
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
public class RegionsController {
	@Autowired
	private RegionRepository repository;
	
	@RequestMapping(value="/regions", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllRegions", nickname="getAllRegions")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Regions.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Regions> getAllRegions(){
		return repository.getAllRegions();
	}
	
	@RequestMapping(value="/regions/{regionID}", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({@ApiImplicitParam(name="regionID", value="region ID", required=true, dataType="Integer", 
		paramType="path")})
	@ApiOperation(value="getLocationsByID", nickname="getLocationsByID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Regions.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Regions getLocationsByID(@PathVariable(value="regionID")Integer regionID){
		return repository.getRegionsByID(regionID);
	}
}
