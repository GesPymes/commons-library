package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class JobModelApi extends JobBaseModelApi {

  @JsonProperty("jobId")
  private String jobId;

  public JobModelApi(
      String calendarId,
      String customerId,
      String customerName,
      String customerLastName,
      String employeeName,
      String employeeLastName,
      String employeeId,
      Integer periodicity,
      Boolean periodic,
      String description,
      String jobId) {
    super(
        calendarId,
        customerId,
        customerName,
        customerLastName,
        employeeName,
        employeeLastName,
        employeeId,
        periodicity,
            periodic,
        description);
    this.jobId = jobId;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("periodicity", this.getPeriodicity());
    params.put("periodic", this.getPeriodic());
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
  @JsonIgnore
  public String getId() {
    return jobId;
  }
}
