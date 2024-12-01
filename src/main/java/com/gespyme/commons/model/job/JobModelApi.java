package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class JobModelApi extends JobBaseModelApi {

  @JsonProperty("jobId")
  private String jobId;

  public JobModelApi(
      String calendarId,
      String customerId,
      String employeeId,
      Integer periodicity,
      Boolean isPeriodic,
      String description,
      String jobId) {
    super(calendarId, customerId, employeeId, periodicity, isPeriodic, description);
    this.jobId = jobId;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("customerId", this.getCustomerId());
    params.put("employeeId", this.getEmployeeId());
    params.put("periodicity", this.getPeriodicity());
    params.put("isPeriodic", this.getIsPeriodic());
    params.put("description", this.getDescription());
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
    return jobId;
  }
}
