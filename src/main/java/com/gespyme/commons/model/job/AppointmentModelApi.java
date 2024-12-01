package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@SuperBuilder
public class AppointmentModelApi extends AppointmentBaseModelApi {
  @JsonProperty("appointmentId")
  private String appointmentId;

  public AppointmentModelApi(
      AppointmentStatus status,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String appointmentId,
      String jobId) {
    super(status, startDate, endDate, jobId);
    this.appointmentId = appointmentId;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("jobId", this.getJobId());
    params.put("status", this.getStatus());
    params.put("startDate", this.getStartDate());
    params.put("endDate", this.getEndDate());
    return params;
  }

  @Override
  public Map<String, Object> selectedParamsMap() {
    return allParamsMap().entrySet().stream()
        .filter(entry -> Objects.nonNull(entry.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public String getId() {
    return appointmentId;
  }
}
