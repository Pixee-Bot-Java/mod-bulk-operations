package org.folio.bulkops.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StaffSlip {
  @JsonProperty("id")
  private String id;

  @JsonProperty("printByDefault")
  private Boolean printByDefault;
}

