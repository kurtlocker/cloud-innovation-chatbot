package com.costco.kraken.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.costco.kraken.model.ConferenceRoom;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ConferenceRoomResp
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

public class ConferenceRoomResp   {
  @JsonProperty("conferenceRooms")
  @Valid
  private List<ConferenceRoom> conferenceRooms = null;

  public ConferenceRoomResp conferenceRooms(List<ConferenceRoom> conferenceRooms) {
    this.conferenceRooms = conferenceRooms;
    return this;
  }

  public ConferenceRoomResp addConferenceRoomsItem(ConferenceRoom conferenceRoomsItem) {
    if (this.conferenceRooms == null) {
      this.conferenceRooms = new ArrayList<ConferenceRoom>();
    }
    this.conferenceRooms.add(conferenceRoomsItem);
    return this;
  }

  /**
   * Get conferenceRooms
   * @return conferenceRooms
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ConferenceRoom> getConferenceRooms() {
    return conferenceRooms;
  }

  public void setConferenceRooms(List<ConferenceRoom> conferenceRooms) {
    this.conferenceRooms = conferenceRooms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceRoomResp conferenceRoomResp = (ConferenceRoomResp) o;
    return Objects.equals(this.conferenceRooms, conferenceRoomResp.conferenceRooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conferenceRooms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceRoomResp {\n");
    
    sb.append("    conferenceRooms: ").append(toIndentedString(conferenceRooms)).append("\n");
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

