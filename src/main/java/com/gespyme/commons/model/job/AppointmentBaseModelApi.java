package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AppointmentBaseModelApi implements Validable {
  @JsonProperty("status")
  private AppointmentStatus status;

  @JsonProperty("startDate")
  private LocalDateTime startDate;

  @JsonProperty("endDate")
  private LocalDateTime endDate;

  @JsonProperty("jobId")
  private String jobId;
}
