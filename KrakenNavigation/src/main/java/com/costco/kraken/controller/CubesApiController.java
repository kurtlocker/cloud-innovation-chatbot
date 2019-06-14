package com.costco.kraken.controller;

import java.math.BigDecimal;

import com.costco.kraken.api.CubesApi;
import com.costco.kraken.model.Cubes;
import com.costco.kraken.model.CubesResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "com.costco.kraken.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

@Controller
public class CubesApiController implements CubesApi {

    private static final Logger log = LoggerFactory.getLogger(CubesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CubesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CubesResp> createCube(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "owner", required = true) String owner,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "cubeNumber", required = true) BigDecimal cubeNumber) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CubesResp>(objectMapper.readValue("{  \"cubes\" : [ {    \"owner\" : \"owner\",    \"location\" : {      \"geometry\" : {        \"coordinates\" : {          \"x\" : 1.4658129805029452,          \"y\" : 5.962133916683182        },        \"type\" : \"type\"      },      \"type\" : \"type\"    },    \"id\" : 0,    \"cubeNumber\" : \"cubeNumber\"  }, {    \"owner\" : \"owner\",    \"location\" : {      \"geometry\" : {        \"coordinates\" : {          \"x\" : 1.4658129805029452,          \"y\" : 5.962133916683182        },        \"type\" : \"type\"      },      \"type\" : \"type\"    },    \"id\" : 0,    \"cubeNumber\" : \"cubeNumber\"  } ]}", CubesResp.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CubesResp>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CubesResp>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cubes> getSpecificCube(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@ApiParam(value = "",required=true) @PathVariable("cubeId") String cubeId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cubes>(objectMapper.readValue("{  \"owner\" : \"owner\",  \"location\" : {    \"geometry\" : {      \"coordinates\" : {        \"x\" : 1.4658129805029452,        \"y\" : 5.962133916683182      },      \"type\" : \"type\"    },    \"type\" : \"type\"  },  \"id\" : 0,  \"cubeNumber\" : \"cubeNumber\"}", Cubes.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cubes>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cubes>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cubes> searchCubes(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "owner", required = true) String owner,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cubes body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cubes>(objectMapper.readValue("{  \"owner\" : \"owner\",  \"location\" : {    \"geometry\" : {      \"coordinates\" : {        \"x\" : 1.4658129805029452,        \"y\" : 5.962133916683182      },      \"type\" : \"type\"    },    \"type\" : \"type\"  },  \"id\" : 0,  \"cubeNumber\" : \"cubeNumber\"}", Cubes.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cubes>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cubes>(HttpStatus.NOT_IMPLEMENTED);
    }

}
