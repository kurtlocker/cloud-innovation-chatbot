package com.costco.kraken.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.costco.kraken.model.Cubes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CubesResp
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T21:16:22.630Z")

public class CubesResp   {
  @JsonProperty("cubes")
  @Valid
  private List<Cubes> cubes = null;

  public CubesResp cubes(List<Cubes> cubes) {
    this.cubes = cubes;
    return this;
  }

  public CubesResp addCubesItem(Cubes cubesItem) {
    if (this.cubes == null) {
      this.cubes = new ArrayList<Cubes>();
    }
    this.cubes.add(cubesItem);
    return this;
  }

  /**
   * Get cubes
   * @return cubes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Cubes> getCubes() {
    return cubes;
  }

  public void setCubes(List<Cubes> cubes) {
    this.cubes = cubes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CubesResp cubesResp = (CubesResp) o;
    return Objects.equals(this.cubes, cubesResp.cubes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cubes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CubesResp {\n");
    
    sb.append("    cubes: ").append(toIndentedString(cubes)).append("\n");
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

