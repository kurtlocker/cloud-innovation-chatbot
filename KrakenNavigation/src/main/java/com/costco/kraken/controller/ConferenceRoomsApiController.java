package com.costco.kraken.controller;

import java.math.BigDecimal;

import com.costco.kraken.api.ConferenceRoomsApi;
import com.costco.kraken.model.ConferenceRoom;
import com.costco.kraken.model.ConferenceRoomResp;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

@Controller
public class ConferenceRoomsApiController implements ConferenceRoomsApi {

    private static final Logger log = LoggerFactory.getLogger(ConferenceRoomsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConferenceRoomsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ConferenceRoom> createConferenceRoom(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@ApiParam(value = "",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConferenceRoom body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConferenceRoom>(objectMapper.readValue("{  \"amenities\" : \"{}\",  \"roomNumber\" : \"roomNumber\",  \"location\" : {    \"geometry\" : {      \"coordinates\" : {        \"x\" : 1.4658129805029452,        \"y\" : 5.962133916683182      },      \"type\" : \"type\"    },    \"type\" : \"type\"  },  \"id\" : 0,  \"capacity\" : 6}", ConferenceRoom.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConferenceRoom>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConferenceRoom>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConferenceRoom> getSingleConferenceRoom(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	System.out.println("Here");
                return new ResponseEntity<ConferenceRoom>(objectMapper.readValue("{  \"amenities\" : \"{}\",  \"roomNumber\" : \"roomNumber\",  \"location\" : {    \"geometry\" : {      \"coordinates\" : {        \"x\" : 1.4658129805029452,        \"y\" : 5.962133916683182      },      \"type\" : \"type\"    },    \"type\" : \"type\"  },  \"id\" : 0,  \"capacity\" : 6}", ConferenceRoom.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConferenceRoom>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConferenceRoom>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConferenceRoomResp> searchConferenceRoom(@ApiParam(value = "" ,required=true) @RequestHeader(value="correlationId", required=true) String correlationId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "ammenities", required = true) String ammenities,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "numPerson", required = true) BigDecimal numPerson,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "roomName", required = true) String roomName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConferenceRoomResp>(objectMapper.readValue("{  \"conferenceRooms\" : [ {    \"amenities\" : \"{}\",    \"roomNumber\" : \"roomNumber\",    \"location\" : {      \"geometry\" : {        \"coordinates\" : {          \"x\" : 1.4658129805029452,          \"y\" : 5.962133916683182        },        \"type\" : \"type\"      },      \"type\" : \"type\"    },    \"id\" : 0,    \"capacity\" : 6  }, {    \"amenities\" : \"{}\",    \"roomNumber\" : \"roomNumber\",    \"location\" : {      \"geometry\" : {        \"coordinates\" : {          \"x\" : 1.4658129805029452,          \"y\" : 5.962133916683182        },        \"type\" : \"type\"      },      \"type\" : \"type\"    },    \"id\" : 0,    \"capacity\" : 6  } ]}", ConferenceRoomResp.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConferenceRoomResp>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConferenceRoomResp>(HttpStatus.NOT_IMPLEMENTED);
    }

}
