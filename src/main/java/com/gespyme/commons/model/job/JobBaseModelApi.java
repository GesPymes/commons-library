package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class JobBaseModelApi implements Validable {

  @JsonProperty("calendarId")
  private String calendarId;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("customerName")
  private String customerName;

  @JsonProperty("customerLastName")
  private String customerLastName;

  @JsonProperty("employeeName")
  private String employeeName;

  @JsonProperty("employeeLastName")
  private String employeeLastName;

  @JsonProperty("employeeId")
  private String employeeId;

  @JsonProperty("periodicity")
  private Integer periodicity;

  @JsonProperty("isPeriodic")
  private Boolean isPeriodic;

  @JsonProperty("description")
  private String description;
}
