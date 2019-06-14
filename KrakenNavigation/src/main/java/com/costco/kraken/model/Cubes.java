package com.costco.kraken.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.costco.kraken.model.GeoJson;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Cubes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

public class Cubes   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("cubeNumber")
  private String cubeNumber = null;

  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("location")
  private GeoJson location = null;

  public Cubes id(Long id) {
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

  public Cubes cubeNumber(String cubeNumber) {
    this.cubeNumber = cubeNumber;
    return this;
  }

  /**
   * Get cubeNumber
   * @return cubeNumber
  **/
  @ApiModelProperty(value = "")


  public String getCubeNumber() {
    return cubeNumber;
  }

  public void setCubeNumber(String cubeNumber) {
    this.cubeNumber = cubeNumber;
  }

  public Cubes owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(value = "")


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Cubes location(GeoJson location) {
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
    Cubes cubes = (Cubes) o;
    return Objects.equals(this.id, cubes.id) &&
        Objects.equals(this.cubeNumber, cubes.cubeNumber) &&
        Objects.equals(this.owner, cubes.owner) &&
        Objects.equals(this.location, cubes.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cubeNumber, owner, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cubes {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cubeNumber: ").append(toIndentedString(cubeNumber)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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

