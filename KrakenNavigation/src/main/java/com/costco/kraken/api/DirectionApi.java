package com.costco.kraken.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.costco.kraken.model.Directions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

@Api(value = "Direction", description = "API endpoint used to calculate direction from a given location to another location")
public interface DirectionApi {

	
	@ApiOperation(value = "", nickname = "calculateRoute", notes = "", response = Directions.class, tags={ "direction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucessfull Operation", response = Directions.class) })
    @RequestMapping(value = "/Direction",
        method = RequestMethod.GET)
	public ResponseEntity<Directions> calculateRoute(
			@ApiParam(value = "", required = false) @Valid @RequestParam(value = "startLocName", required = true) String start,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "endLocName", required = true) String destination);
	
}
