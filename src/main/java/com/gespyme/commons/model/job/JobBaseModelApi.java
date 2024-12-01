package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
public abstract class JobBaseModelApi implements Validable {

  @JsonProperty("calendarId")
  private String calendarId;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("employeeId")
  private String employeeId;

  @JsonProperty("periodicity")
  private Integer periodicity;

  @JsonProperty("isPeriodic")
  private Boolean isPeriodic;

  @JsonProperty("description")
  private String description;
}
