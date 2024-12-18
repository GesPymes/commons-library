package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
  @JsonIgnore
  public String getId() {
    return appointmentId;
  }
}
