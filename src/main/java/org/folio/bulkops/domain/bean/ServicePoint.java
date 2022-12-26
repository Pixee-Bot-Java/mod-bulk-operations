package org.folio.bulkops.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import software.amazon.awssdk.services.budgets.model.TimePeriod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@With
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ServicePoint   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("code")
  private String code;

  @JsonProperty("discoveryDisplayName")
  private String discoveryDisplayName;

  @JsonProperty("description")
  private String description;

  @JsonProperty("shelvingLagTime")
  private Integer shelvingLagTime;

  @JsonProperty("pickupLocation")
  private Boolean pickupLocation;

  @JsonProperty("holdShelfExpiryPeriod")
  private TimePeriod holdShelfExpiryPeriod;

  @JsonProperty("staffSlips")
  @Valid
  private List<StaffSlip> staffSlips = null;

  @JsonProperty("metadata")
  private Metadata metadata;
}

