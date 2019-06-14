package com.costco.kraken.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.costco.kraken.model.GeoJson;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ConferenceRoom
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

public class ConferenceRoom   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("roomNumber")
  private String roomNumber = null;

  @JsonProperty("capacity")
  private Integer capacity = null;

  @JsonProperty("amenities")
  private Object amenities = null;

  @JsonProperty("location")
  private GeoJson location = null;

  public ConferenceRoom id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ConferenceRoom roomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
    return this;
  }

  /**
   * Get roomNumber
   * @return roomNumber
  **/
  @ApiModelProperty(value = "")


  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public ConferenceRoom capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Get capacity
   * @return capacity
  **/
  @ApiModelProperty(value = "")


  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public ConferenceRoom amenities(Object amenities) {
    this.amenities = amenities;
    return this;
  }

  /**
   * Get amenities
   * @return amenities
  **/
  @ApiModelProperty(value = "")


  public Object getAmenities() {
    return amenities;
  }

  public void setAmenities(Object amenities) {
    this.amenities = amenities;
  }

  public ConferenceRoom location(GeoJson location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GeoJson getLocation() {
    return location;
  }

  public void setLocation(GeoJson location) {
    this.location = location;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceRoom conferenceRoom = (ConferenceRoom) o;
    return Objects.equals(this.id, conferenceRoom.id) &&
        Objects.equals(this.roomNumber, conferenceRoom.roomNumber) &&
        Objects.equals(this.capacity, conferenceRoom.capacity) &&
        Objects.equals(this.amenities, conferenceRoom.amenities) &&
        Objects.equals(this.location, conferenceRoom.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, roomNumber, capacity, amenities, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceRoom {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    roomNumber: ").append(toIndentedString(roomNumber)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

