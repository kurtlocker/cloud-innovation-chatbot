/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.5).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.costco.kraken.api;

import java.math.BigDecimal;
import com.costco.kraken.model.Cubes;
import com.costco.kraken.model.CubesResp;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

@Api(value = "Cubes", description = "the Cubes API")
public interface CubesApi {

    @ApiOperation(value = "", nickname = "createCube", notes = "", response = CubesResp.class, tags={ "location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucessfull Operation", response = CubesResp.class) })
    @RequestMapping(value = "/Cubes",
        method = RequestMethod.GET)
    ResponseEntity<CubesResp> createCube(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "owner", required = true) String owner,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "cubeNumber", required = true) BigDecimal cubeNumber);


    @ApiOperation(value = "", nickname = "getSpecificCube", notes = "", response = Cubes.class, tags={ "location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucessfull Operation", response = Cubes.class) })
    @RequestMapping(value = "/Cubes/{cubeId}",
        method = RequestMethod.GET)
    ResponseEntity<Cubes> getSpecificCube(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@ApiParam(value = "",required=true) @PathVariable("cubeId") String cubeId);


    @ApiOperation(value = "", nickname = "searchCubes", notes = "", response = Cubes.class, tags={ "location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Sucessfull Operation", response = Cubes.class) })
    @RequestMapping(value = "/Cubes",
        method = RequestMethod.POST)
    ResponseEntity<Cubes> searchCubes(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "owner", required = true) String owner,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cubes body);

}
