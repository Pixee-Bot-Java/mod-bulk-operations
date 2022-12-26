package org.folio.bulkops.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@With
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Errors   {
  @JsonProperty("errors")
  @Valid
  private List<Error> errors = null;

  @JsonProperty("total_records")
  private Integer totalRecords;
}

